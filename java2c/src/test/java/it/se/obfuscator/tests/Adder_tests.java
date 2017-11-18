package it.se.obfuscator.tests;
import it.se.obfuscator.Java2CMain;
import it.se.obfuscator.helpers.ConvertClasses;
import org.junit.*;
import testclasses.Adder;

import java.io.File;
import java.io.IOException;

public class Adder_tests
{
    private final String className = "Adder.class";

    public Adder_tests()
    {

    }

//    @Before
//    public void convert_class()
//    {
//        //locate .class file
//        ClassLoader classLoader = getClass().getClassLoader();
//        File source = new File(classLoader.getResource("Adder.class").getFile());
//        Java2CMain trans = new Java2CMain();
//        String args[] = new String[2];
//        args[0] = source.getAbsolutePath(); //Adder.class path
//        args[1] = source.getParentFile().getAbsolutePath(); //Adder.class parent folder (output)
//
//        //makefile
//        ProcessBuilder makefileRun = new ProcessBuilder("/usr/bin/make","PARENTDIR="+source.getParentFile().getAbsolutePath());
//        makefileRun.inheritIO();
//        makefileRun.directory(new File(source.getParentFile().getParentFile().getParentFile().getParentFile().getAbsolutePath()));
//        try
//        {
//            trans.parseClass(args);
//            Process child = makefileRun.start();
//            child.waitFor(); //wait for make to end, otherwise tests will run with the library not ready
//
//        }
//        catch (IOException | InterruptedException e)
//        {
//            e.printStackTrace();
//        }
//    }

    @BeforeClass
    public static void convert_classes()
    {
        try
        {
            ConvertClasses.convertAll();
        } catch (IOException e)
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

    @AfterClass
    public static void delete_converted()
    {
        try
        {
            ConvertClasses.deleteConverted();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
