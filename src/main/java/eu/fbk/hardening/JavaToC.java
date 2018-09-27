package eu.fbk.hardening;

import eu.fbk.hardening.support.ClassMethodPair;
import eu.fbk.hardening.support.ExtractedBytecode;
import eu.fbk.hardening.support.ClassMethodPair;
import eu.fbk.hardening.support.ExtractedBytecode;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JavaToC
{
    private PrintWriter output;
    private String libname;
    private boolean parsing;

    public JavaToC()
    {
        parsing = false;
    }

    private void appendHeaderFile(final String filename)
    {
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream(filename);
        String fileContent = new BufferedReader(new InputStreamReader(stream))
                .lines().collect(Collectors.joining("\n"));
        output.write(fileContent);
        output.write("\n");
    }

    private void printHeader()
    {
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
    }

    public void startParsing(final String outputFolder, final String libname) throws IOException
    {
        this.libname = libname;
        String output = outputFolder;
        if(parsing)
            throw new IOException("Still parsing another library. Forgot to call endParsing()?");
        if(outputFolder.charAt(outputFolder.length()-1)!= File.separatorChar)
            output+=File.separator;
        File outputDir = new File(output); //create output directory
        if(!outputDir.exists())
            if(!outputDir.mkdirs())
                throw new IOException("Unable to create directory "+output);
        this.output = new PrintWriter(new FileOutputStream(output+libname+".c"));
        printHeader();
        parsing = true;
    }

    public void parseClass(final String inputClassPath) throws IOException
    {
        if(!parsing)
            throw new IOException("startParsing() function must be called first!");
        InputStream inputClass = new FileInputStream(inputClassPath);;
        OutputStream outputClass;
        ClassReader classReader = new ClassReader(inputClass);;
        ClassWriter classWriter;
        ClassAnnotationExplorer annotationExplorer;
        ClassBytecodeExtractor bytecodeExtractor;
        ClassCodeEliminator codeEliminator;

        //first pass, visit annotated methods
        annotationExplorer = new ClassAnnotationExplorer();
        classReader.accept(annotationExplorer,0);
        ArrayList<ClassMethodPair> methodsToProcess = annotationExplorer.obfuscateThese();
        if(methodsToProcess.size()==0) //nothing to obfuscate in this class
        {
            inputClass.close();
            return;
        }
//        if(hasOverloading(methodsToProcess))
//        {
//            throw new IllegalPatternException("Overloaded methods are not supported");
//        }

        //second pass, extract instructions from methods
        bytecodeExtractor = new ClassBytecodeExtractor(methodsToProcess);
        classReader.accept(bytecodeExtractor,0);
        ArrayList<ExtractedBytecode> extractedBytecodes = bytecodeExtractor.getBytecode();

        //third pass, modify the class by removing the methods' bodies and adding static init
        classWriter = new ClassWriter(classReader,0);
        codeEliminator = new ClassCodeEliminator(methodsToProcess, libname, classWriter);
        classReader.accept(codeEliminator,0);

        //next step: convert the ExtractedBytecode to actual c code
        StringBuilder c = new StringBuilder();

        //this cannot change since only 1 file is processed as input
        ClassMethodPair className;
        for(int j=0;j<extractedBytecodes.size();j++)
        {
            className = methodsToProcess.get(j);
            ExtractedBytecode bytecode = extractedBytecodes.get(j);
            bytecode.postprocess(); //remove unnecessary labels. Otherwise empty labels could be created and gcc fails
            c.append(CSourceGenerator.generateCode(className.getClassName(),className.getMethodName(), className.getSignature(),bytecode,className.overloaded));
        }
        this.output.write(c.toString());

        inputClass.close();
        outputClass = new FileOutputStream(inputClassPath);
        outputClass.write(classWriter.toByteArray());
        outputClass.close();
    }

    public void endParsing()
    {
        if(parsing)
        {
            output.close();
            parsing = false;
        }
    }

    private static boolean hasOverloading(List<ClassMethodPair> list)
    {
        /*
        TODO: REMOVE THIS THING!
        -> implies generating the stub with javah instead of guessing it, so the c compiler does not complains about
            conflicting file names. Not as easy as it seems, because it requires parsing a .h file from java to know
            which method has which stub
        */

        //O(n^2)... but hopefully this will be a tmp solution
        for(int i = 0; i < list.size(); i++)
        {
            for(int j = 0; j < list.size(); j++)
            {
                if(i != j)
                {
                    if(list.get(i).getClassName().equals(list.get(j).getClassName()) &&
                            list.get(i).getMethodName().equals(list.get(j).getMethodName()))
                        return true;
                }
            }
        }
        return false;
    }
}
