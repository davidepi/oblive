package it.se.obfuscator.helpers;

import it.se.obfuscator.Java2CMain;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ClassConverter
{
    private final static String TESTS_PACKAGE = "testclasses";

    public static void convertAll() throws IOException,InterruptedException
    {
        Path source = Paths.get("build/convertedclasses/test/"+TESTS_PACKAGE);
        if(Files.notExists(source)) //if the converted classes do not exist
        {
            ClassConverter.copyFiles();
            Java2CMain trans = new Java2CMain();
            List<String> files = new ArrayList<String>();
            files = getFileNames(files,source); //get files
            String libsrc_path = Paths.get("build").toAbsolutePath().toString();
            files.add(libsrc_path); //output for the c files

            //makefile
            ProcessBuilder makefileRun = new ProcessBuilder("make","PARENTDIR="+libsrc_path);
            makefileRun.inheritIO();
            makefileRun.directory(new File(Paths.get(".").toAbsolutePath().toString()));
            trans.parseClass(files.toArray(new String[0]));
            Process child = makefileRun.start();
            child.waitFor(); //wait for make to end, otherwise tests will run with the library not ready
        }
    }

    public static void copyFiles() throws IOException
    {
        Path dest = Paths.get("build/convertedclasses/test/"+TESTS_PACKAGE);
        Path source = Paths.get("build/classes/test/"+TESTS_PACKAGE);
        if(Files.notExists(source)) //also the sources are missing
            throw new IOException();
        Files.copy(source.getParent().getParent(),dest.getParent().getParent()); //copy converted_classes
        Files.copy(source.getParent(),dest.getParent()); //copy tests
        copyFolder(source,dest);
    }

    private static List<String> getFileNames(List<String> fileNames, Path dir) throws IOException
    {
        DirectoryStream<Path> stream = Files.newDirectoryStream(dir);
        for (Path path : stream)
        {
            if(path.toFile().isDirectory())
            {
                getFileNames(fileNames, path);
            }
            else
            {
                fileNames.add(path.toAbsolutePath().toString());
            }
        }
        return fileNames;
    }

    public static void deleteConverted() throws IOException
    {
        Path dest = Paths.get("build/convertedclasses");
        if(Files.exists(dest))
            deleteFolder(dest);
    }

    private static void copyFolder(Path source, Path dest) throws IOException
    {
        if(Files.isDirectory(source)) //ensure it is a folder
        {
            Files.copy(source,dest); //copy the folder
            DirectoryStream<Path> stream = Files.newDirectoryStream(source);
            for(Path entry : stream) //copy recursively the files
            {

                if(Files.isDirectory(entry))
                    copyFolder(entry,Paths.get(dest.toString()+"/"+entry.getFileName()));
                else
                    Files.copy(entry,Paths.get(dest.toString()+"/"+entry.getFileName()));
            }
        }
        else
            return;
    }

    private static void deleteFolder(Path source) throws IOException
    {
        if(Files.isDirectory(source))
        {
            DirectoryStream<Path> stream = Files.newDirectoryStream(source);
            for(Path entry : stream)
            {
                if(Files.isDirectory(entry))
                    deleteFolder(entry);
                else
                    Files.delete(entry);
            }
            Files.delete(source);
        }
        else
            return;
    }
}
