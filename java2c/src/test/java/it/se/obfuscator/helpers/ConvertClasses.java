package it.se.obfuscator.helpers;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConvertClasses
{
    private final static String TESTS_PACKAGE = "testclasses";

    public static void convertAll() throws IOException
    {
        Path dest = Paths.get("./build/convertedclasses/test/"+TESTS_PACKAGE);
        if(Files.notExists(dest.getParent().getParent())) //if the converted classes do not exist
        {
            Path source = Paths.get("./build/classes/test/"+TESTS_PACKAGE);
            if(Files.notExists(source)) //also the sources are missing
                throw new IOException();
            Files.copy(source.getParent().getParent(),dest.getParent().getParent()); //copy converted_classes
            Files.copy(source.getParent(),dest.getParent()); //copy tests
            copyFolder(source,dest);
        }
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
}
