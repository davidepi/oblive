import it.se.obfuscator.Java2CMain;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Adder_tests
{
    private final String className = "Adder.class";

    public Adder_tests()
    {

    }

    @Before
    public void copy_class()
    {
        ClassLoader classLoader = getClass().getClassLoader();
        File source = new File(classLoader.getResource("Adder.class").getFile());
        File dest =  new File(source.getParentFile().getAbsolutePath()+"/Adder_copy.class");
        try
        {
            Files.copy(source.toPath(),dest.toPath());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void test_Adder_sum()
    {
        ClassLoader classLoader = getClass().getClassLoader();
        File source = new File(classLoader.getResource("Adder.class").getFile());
        Java2CMain trans = new Java2CMain();
        String args[] = new String[2];
        args[0] = source.getParentFile().getAbsolutePath()+"/Adder_copy.class";
        args[1] = source.getParentFile().getAbsolutePath();
        ProcessBuilder makefileRun = new ProcessBuilder("/usr/bin/make","PARENTDIR="+source.getParentFile().getAbsolutePath());
        makefileRun.inheritIO();
        makefileRun.directory(new File("/Users/davide/Documents/Xcode/java2c/java2c/"));
        try
        {
            trans.parseClass(args);
            makefileRun.start();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
    }

    @After
    public void delete_class()
    {
        ClassLoader classLoader = getClass().getClassLoader();
        File source = new File(classLoader.getResource("Adder.class").getFile());
        File toDelete = new File(source.getParentFile().getAbsolutePath()+"/Adder_copy.class");
        File libsrcDirToDelete = new File(source.getParentFile().getAbsolutePath()+"/libsrc");
        toDelete.delete();
        libsrcDirToDelete.delete();
    }
}
