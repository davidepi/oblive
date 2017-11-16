import it.se.obfuscator.Java2CMain;
import it.se.obfuscator.Obfuscate;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class Adder_tests
{
    private final String className = "Adder.class";

    public Adder_tests()
    {

    }

    @Before
    public void convert_class()
    {
        //locate .class file
        ClassLoader classLoader = getClass().getClassLoader();
        File source = new File(classLoader.getResource("Adder.class").getFile());
        Java2CMain trans = new Java2CMain();
        String args[] = new String[2];
        args[0] = source.getAbsolutePath(); //Adder.class path
        args[1] = source.getParentFile().getAbsolutePath(); //Adder.class parent folder (output)

        //makefile
        ProcessBuilder makefileRun = new ProcessBuilder("/usr/bin/make","PARENTDIR="+source.getParentFile().getAbsolutePath());
        makefileRun.inheritIO();
        makefileRun.directory(new File(source.getParentFile().getParentFile().getParentFile().getParentFile().getAbsolutePath()));
        try
        {
            trans.parseClass(args);
            Process child = makefileRun.start();
            child.waitFor();

        }
        catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void test_Adder_sum()
    {
        Adder a = new Adder();
        Assert.assertEquals(33,a.add(15,18));
    }

    @After
    public void delete_class()
    {
        ClassLoader classLoader = getClass().getClassLoader();
        File source = new File(classLoader.getResource("Adder.class").getFile());

        //delete libsrc and content
        //make fails if uncommenting these...
//        File libsrc = new File(source.getParentFile().getAbsolutePath()+"/libsrc");
//        File[] contents = libsrc.listFiles();
//        for(int i=0;i<contents.length;i++)
//            contents[i].delete();
//        libsrc.delete();

        source.delete(); //delete .class file, otherwise next time it won't be converted properly
    }
}
