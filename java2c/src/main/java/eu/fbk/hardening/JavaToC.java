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

public class JavaToC
{
    public JavaToC(){}

    public static void parseClass(final String input, final String output, final String libname, boolean overwrite) throws IOException
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
        if(hasOverloading(methodsToProcess))
        {
            throw new IllegalPatternException("Overloaded methods are not supported");
        }

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
            c.append(CSourceGenerator.generateCode(className.getClassName(),className.getMethodName(),className.getSignature(),bytecode));
        }
        File libout = new File(outputPath+libname+".c");
        PrintWriter cFileWriter;
        if(overwrite || !libout.exists())
        {
            //newly created file, add includes
            cFileWriter = new PrintWriter(new FileOutputStream(libout,false));
            cFileWriter.write("#include <jni.h>\n#include \"cframework.h\"\n\n");
        }
        else
        {
            //already existing file, no need for includes
            cFileWriter = new PrintWriter(new FileOutputStream(libout,true));
        }
        cFileWriter.write(c.toString());
        cFileWriter.close();

        inputClass.close();
        outputClass = new FileOutputStream(input);
        outputClass.write(classWriter.toByteArray());
        outputClass.close();
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
