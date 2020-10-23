package it.oblive;

import it.oblive.annotations.AntidebugSelf;
import it.oblive.support.ClassMethodPair;
import it.oblive.support.ExtractedBytecode;
import it.oblive.visitors.ClassAnnotationExplorer;
import it.oblive.visitors.ClassBytecodeExtractor;
import it.oblive.visitors.ClassCodeEliminator;
import org.jetbrains.annotations.Contract;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import javax.crypto.SecretKey;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Class performing the actual Java2C transformation.
 * This class needs to be initialized with startParsing() and deinitialized with endParsing()
 *
 * @author D.Pizzolotto
 */
public class JavaToC {
    private static final int ASM_VERSION = Opcodes.ASM8;
    private CSourceGenerator generator;
    private String libname;
    private boolean parsing;
    private File outCsource; //output file that will contain the C source for the main program
    private Path antidebugVMsource; //the file containing vm logic for self debug
    private boolean antidebugSelf; //antidebug requires additional files to be written
    private String vmTable; //VM table opcodes for self debugging
    private SecretKey authKey;

    /**
     * Default constructor
     */
    @Contract(pure = true)
    public JavaToC() {
        parsing = false;
        antidebugSelf = false;
    }

    /**
     * Starts the Java2C transformation. This method can be seen as a sort of initialization.
     *
     * @param outCSource The output .c lib that will be generated. name MUST start with lib and, possibly, end
     *                   with .c
     * @throws IOException Exception indicating that another parsing is in progress or insufficient permissions
     */
    public void startParsing(File outCSource) throws IOException {
        this.libname = outCSource.getName().substring(0, outCSource.getName().lastIndexOf('.'));
        if (!this.libname.startsWith("lib")) {
            throw new IOException("The requested output filename for Java2C does not start with 'lib'");
        }
        if (parsing) {
            throw new IOException("Still parsing another library. Forgot to call endParsing()?");
        }
        if (!outCSource.getParentFile().exists()) {
            if (!outCSource.getParentFile().mkdirs()) {
                throw new IOException("Unable to create directory " + outCSource.getParentFile());
            }
        }
        this.antidebugVMsource = Paths.get(outCSource.toPath().getParent().toString(), this.libname + "vm.c");
        this.outCsource = outCSource;
        this.vmTable = CSourceGenerator.generateVMTable();
        Stack<SecretKey> keys = CSourceGenerator.generateKeys(2);
        this.authKey = keys.pop();
        this.generator = new CSourceGenerator();
        SecretKey maskParent = keys.pop();
        generator.addHeader(CSourceGenerator.getKeyAsMaskedCString(authKey, maskParent, "auth_key"));
        generator.addHeader(CSourceGenerator.getKeyAsCString(maskParent, "mask_key"));
        generator.addHeader(this.vmTable);
        generator.addHeader(generator.getResources("cframework.h"));
        generator.addHeader(generator.getResources("xoshiro256starstar.c"));
        generator.addHeader(generator.getResources("antidebug.h"));
        generator.addHeader(generator.getResources("stack.h"));
        generator.addHeader(generator.getResources("arithmetic.h"));
        generator.addHeader(generator.getResources("arrays.h"));
        generator.addHeader(generator.getResources("casts.h"));
        generator.addHeader(generator.getResources("conditionals.h"));
        generator.addHeader(generator.getResources("fields.h"));
        generator.addHeader(generator.getResources("invoke.h"));
        generator.addHeader(generator.getResources("multi_arrays.h"));
        generator.addHeader(generator.getResources("new.h"));
        parsing = true;
    }

    /**
     * Parse a single class.
     *
     * @param inputClassPath The class that will be analyzed
     * @throws IOException Exception indicating that startParsing() has not been called or the class has not been found
     */
    public void parseClass(final String inputClassPath) throws IOException {
        if (!parsing) {
            throw new IOException("startParsing() function must be called first!");
        }
        InputStream inputClass = new FileInputStream(inputClassPath);
        OutputStream outputClass;
        ClassReader classReader = new ClassReader(inputClass);
        ClassWriter classWriter;
        ClassAnnotationExplorer annotationExplorer;
        ClassBytecodeExtractor bytecodeExtractor;
        ClassCodeEliminator codeEliminator;

        //first pass, visit annotated methods
        annotationExplorer = new ClassAnnotationExplorer(ASM_VERSION);
        classReader.accept(annotationExplorer, 0);
        ArrayList<ClassMethodPair> methodsToProcess = annotationExplorer.obfuscateThese();
        if (methodsToProcess.size() == 0) //nothing to obfuscate in this class
        {
            inputClass.close();
            return;
        }

        //second pass, extract instructions from methods
        bytecodeExtractor = new ClassBytecodeExtractor(ASM_VERSION, methodsToProcess);
        classReader.accept(bytecodeExtractor, 0);
        ArrayList<ExtractedBytecode> extractedBytecodes = bytecodeExtractor.getBytecode();

        //third pass, modify the class by removing the methods' bodies and adding static init
        classWriter = new ClassWriter(classReader, 0);
        codeEliminator = new ClassCodeEliminator(ASM_VERSION, methodsToProcess, libname.substring(3), classWriter);
        classReader.accept(codeEliminator, 0);

        //this cannot change since only 1 file is processed as input
        ClassMethodPair className;
        for (int j = 0; j < extractedBytecodes.size(); j++) {
            className = methodsToProcess.get(j);
            ExtractedBytecode bytecode = extractedBytecodes.get(j);
            bytecode.postprocess(); //remove unnecessary labels. Otherwise empty labels could be created and gcc fails
            generator.addNativeMethod(className.getClassName(), className.getMethodName(),
                    className.getSignature(), bytecode, className.overloaded, className.getRequestedObfuscations(),
                    this.libname);
            antidebugSelf |= className.getRequestedObfuscations().contains(AntidebugSelf.class);
        }
        inputClass.close();
        outputClass = new FileOutputStream(inputClassPath);
        outputClass.write(classWriter.toByteArray());
        outputClass.close();
    }

    /**
     * Finalized the parsing
     */
    public void endParsing() throws IOException {
        if (parsing) {
            if (antidebugSelf) {
                InputStream stream = this.getClass().getClassLoader().getResourceAsStream("antidebug.c");
                assert stream != null;
                String fileContent = new BufferedReader(new InputStreamReader(stream))
                        .lines().collect(Collectors.joining("\n"));
                PrintWriter writer = new PrintWriter(new FileOutputStream(this.antidebugVMsource.toString()));
                Stack<SecretKey> keys = CSourceGenerator.generateKeys(1);
                SecretKey maskChild = keys.pop();
                writer.write(CSourceGenerator.getKeyAsMaskedCString(this.authKey, maskChild, "auth_key"));
                writer.write(CSourceGenerator.getKeyAsCString(maskChild, "mask_key"));
                writer.write(this.vmTable);
                writer.write(generator.getResources("xoshiro256starstar.c"));
                writer.write("\n");
                writer.write(fileContent);
                writer.close();
                antidebugSelf = false;
                generator.addGlobalDefine("SELF_DEBUG", null);
            }
            generator.writeToFile(this.outCsource.toString());
            parsing = false;
        }
    }
}
