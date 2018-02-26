package it.se.obfuscator.helpers;

import it.se.obfuscator.JavaToC;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class ClassTransformer
{

    public static void transform(final String classname) throws IOException,InterruptedException
    {
        ClassTransformer.copyFile(classname);
        String libname = classname.replaceFirst("\\.class","").replace('/','.');
        String transformMe = Paths.get("build/transformedclasses/test/"+classname).toAbsolutePath().toString();
        String libsrcPath = Paths.get("build/libsrc").toAbsolutePath().toString();

        //transform class
        JavaToC.parseClass(transformMe,libsrcPath,libname);

        //makefile
        ProcessBuilder makefileRun = new ProcessBuilder("make","SRCDIR="+libsrcPath,"OUTDIR="+libsrcPath,
                                                        "SRCNAME="+libname,"LIBNAME="+libname);
        makefileRun.inheritIO();
        makefileRun.directory(new File(Paths.get(".").toAbsolutePath().toString()));
        Process child = makefileRun.start();
        child.waitFor(); //wait for make to end, otherwise tests will run with the library not ready
    }

    public static void copyFile(final String classname) throws IOException
    {
        Path dest = Paths.get("build/transformedclasses/test/"+classname);
        Path source = Paths.get("build/classes/java/test/"+classname);
        if(Files.notExists(source)) //also the sources are missing
            throw new IOException();
        if(Files.notExists(dest.getParent())) //create the transformedclass folder if not exists
            Files.createDirectories(dest.getParent());
        Files.copy(source,dest,REPLACE_EXISTING);
    }
}
