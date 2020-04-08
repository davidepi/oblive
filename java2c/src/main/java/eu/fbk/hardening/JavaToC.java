package eu.fbk.hardening;

import eu.fbk.hardening.support.ClassMethodPair;
import eu.fbk.hardening.support.ExtractedBytecode;
import eu.fbk.hardening.visitors.ClassAnnotationExplorer;
import eu.fbk.hardening.visitors.ClassBytecodeExtractor;
import eu.fbk.hardening.visitors.ClassCodeEliminator;
import org.jetbrains.annotations.Contract;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Class performing the actual Java2C transformation.
 * This class needs to be initialized with startParsing() and deinitialized with endParsing()
 *
 * @author D.Pizzolotto
 */
public class JavaToC {
    private static final int ASM_VERSION = Opcodes.ASM6;
    private PrintWriter output;
    private String libname;
    private boolean parsing;

    /**
     * Default constructor
     */
    @Contract(pure = true)
    public JavaToC() {
        parsing = false;
    }

    /**
     * Append the content of a header C file to the output file
     *
     * @param filename Name of the INPUT C  header file
     */
    private void appendHeaderFile(final String filename) {
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream(filename);
        assert stream != null;
        String fileContent = new BufferedReader(new InputStreamReader(stream))
                .lines().collect(Collectors.joining("\n"));
        output.write(fileContent);
        output.write("\n");
    }


    private void printHeader() {
        appendHeaderFile("cframework.h");
        appendHeaderFile("stack.h");
        appendHeaderFile("arithmetic.h");
        appendHeaderFile("arrays.h");
        appendHeaderFile("casts.h");
        appendHeaderFile("conditionals.h");
        appendHeaderFile("fields.h");
        appendHeaderFile("invoke.h");
        appendHeaderFile("multi_arrays.h");
        appendHeaderFile("new.h");
        appendHeaderFile("antidebug.h");
    }

    /**
     * Starts the Java2C transformation. This method can be seen as a sort of initialization.
     *
     * @param outputFolder The output folder of the processed class files
     * @param libname      name of the generated C library
     * @throws IOException Exception indicating that another parsing is in progress or insufficient permissions
     */
    public void startParsing(final String outputFolder, final String libname) throws IOException {
        this.libname = libname;
        String output = outputFolder;
        if (parsing) {
            throw new IOException("Still parsing another library. Forgot to call endParsing()?");
        }
        if (outputFolder.charAt(outputFolder.length() - 1) != File.separatorChar) {
            output += File.separator;
        }
        File outputDir = new File(output); //create output directory
        if (!outputDir.exists()) {
            if (!outputDir.mkdirs()) {
                throw new IOException("Unable to create directory " + output);
            }
        }
        this.output = new PrintWriter(new FileOutputStream(output + libname + ".c"));
        printHeader();
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
        codeEliminator = new ClassCodeEliminator(ASM_VERSION, methodsToProcess, libname, classWriter);
        classReader.accept(codeEliminator, 0);

        //next step: convert the ExtractedBytecode to actual c code
        StringBuilder c = new StringBuilder();

        //this cannot change since only 1 file is processed as input
        ClassMethodPair className;
        for (int j = 0; j < extractedBytecodes.size(); j++) {
            className = methodsToProcess.get(j);
            ExtractedBytecode bytecode = extractedBytecodes.get(j);
            bytecode.postprocess(); //remove unnecessary labels. Otherwise empty labels could be created and gcc fails
            c.append(CSourceGenerator.generateCode(className.getClassName(), className.getMethodName(),
                    className.getSignature(), bytecode, className.overloaded, className.getRequestedObfuscations()));
        }
        this.output.write(c.toString());

        inputClass.close();
        outputClass = new FileOutputStream(inputClassPath);
        outputClass.write(classWriter.toByteArray());
        outputClass.close();
    }

    /**
     * Finalized the parsing
     */
    public void endParsing() {
        if (parsing) {
            output.close();
            parsing = false;
        }
    }
}
