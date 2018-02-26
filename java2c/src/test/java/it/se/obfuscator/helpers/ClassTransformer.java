package it.se.obfuscator.helpers;

import it.se.obfuscator.Java2CMain;

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
        Java2CMain trans = new Java2CMain();
        List<String> files = new ArrayList<String>();
        String transformMe = Paths.get("build/transformedclasses/test/"+classname).toAbsolutePath().toString();
        String libsrcPath = Paths.get("build").toAbsolutePath().toString();
        files.add(transformMe); //file that will be transformed
        files.add(libsrcPath); //output for the c files

        //makefile
        ProcessBuilder makefileRun = new ProcessBuilder("make","PARENTDIR="+libsrcPath);
        makefileRun.inheritIO();
        makefileRun.directory(new File(Paths.get(".").toAbsolutePath().toString()));
        trans.parseClass(files.toArray(new String[0]));
        Process child = makefileRun.start();
        child.waitFor(); //wait for make to end, otherwise tests will run with the library not ready
    }

    public static void copyFile(final String classname) throws IOException
    {
        Path dest = Paths.get("build/transformedclasses/test/"+classname);
        Path source = Paths.get("build/classes/test/"+classname);
        if(Files.notExists(source)) //also the sources are missing
            throw new IOException();
        if(Files.notExists(dest.getParent())) //create the transformedclass folder if not exists
            Files.createDirectories(dest.getParent());
        Files.copy(source,dest,REPLACE_EXISTING);
    }
}
