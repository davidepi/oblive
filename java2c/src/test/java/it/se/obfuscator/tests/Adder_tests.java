package it.se.obfuscator.tests;

import it.se.obfuscator.helpers.ConvertClasses;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import testclasses.Adder;

import java.io.IOException;

public class Adder_tests
{
    public Adder_tests()
    {

    }

    @BeforeClass
    public static void convert_classes()
    {
        try
        {
            ConvertClasses.convertAll();
        } catch (IOException | InterruptedException e)
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
}
