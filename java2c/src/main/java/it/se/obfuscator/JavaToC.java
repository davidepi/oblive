package it.se.obfuscator;

import it.se.obfuscator.support.ClassMethodPair;
import it.se.obfuscator.support.ExtractedBytecode;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.*;
import java.util.ArrayList;

public class JavaToC
{
    public JavaToC(){}

    public static void parseClass(final String input, final String output, final String libname) throws IOException
    {
        String outputPath = output;
        if(outputPath.charAt(outputPath.length()-1)!= File.separatorChar)
            outputPath+=File.separator;
        File outputDir = new File(outputPath); //create output directory
        if(!outputDir.exists())
            outputDir.mkdirs();
        InputStream inputClass;
        OutputStream outputClass;
        ClassReader classReader;
        ClassWriter classWriter;
        ClassAnnotationExplorer annotationExplorer;
        ClassBytecodeExtractor bytecodeExtractor;
        ClassCodeEliminator codeEliminator;

        //MAIN
        inputClass = new FileInputStream(input);
        classReader = new ClassReader(inputClass);

        //first pass, visit annotated methods
        annotationExplorer = new ClassAnnotationExplorer();
        classReader.accept(annotationExplorer,0);
        ArrayList<ClassMethodPair> methodsToProcess = annotationExplorer.obfuscateThese();
        if(methodsToProcess.size()==0) //nothing to obfuscate in this class
        {
            inputClass.close();
            return;
        }

        //second pass, extract instructions from methods
        bytecodeExtractor = new ClassBytecodeExtractor(methodsToProcess);
        classReader.accept(bytecodeExtractor,0);
        ArrayList<ExtractedBytecode> extractedBytecodes = bytecodeExtractor.getBytecode();

        //third pass, modify the class by removing the methods' bodies and adding static init
        classWriter = new ClassWriter(classReader,0);
        codeEliminator = new ClassCodeEliminator(methodsToProcess,libname,classWriter);
        classReader.accept(codeEliminator,0);

        //next step: convert the ExtractedBytecode to actual c code
        StringBuilder c = new StringBuilder("#include <jni.h>\n#include \"cframework.h\"\n\n");

        //this cannot change since only 1 file is processed as input
        ClassMethodPair className;
        for(int j=0;j<extractedBytecodes.size();j++)
        {
            className = methodsToProcess.get(j);
            ExtractedBytecode bytecode = extractedBytecodes.get(j);
            bytecode.stripLabels(); //remove unnecessary labels. Otherwise empty labels could be created and gcc fails
            c.append(CSourceGenerator.generateCode(className.getClassName(),className.getMethodName(),className.getSignature(),bytecode));
        }
        PrintWriter cFileWriter = new PrintWriter(outputPath+libname+".c");
        cFileWriter.write(c.toString());
        cFileWriter.close();

        inputClass.close();
        outputClass = new FileOutputStream(input);
        outputClass.write(classWriter.toByteArray());
        outputClass.close();
    }
}
