package it.se.obfuscator.support;

import it.se.obfuscator.IllegalPatternException;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestJniType
{
    @Test
    public void testInteger()
    {
        JniType type = new JniType("I");
        assertEquals(type.getName(),"jint");
        assertEquals(type.getJniName(),"jint");
        assertEquals(type.isDoubleLength(),false);
        assertEquals(type.isFloatingPoint(),false);
    }

    @Test
    public void testObject()
    {
        JniType type = new JniType("Ljava/util/String;");
        assertEquals(type.getName(),"java/util/String");
        assertEquals(type.getJniName(),"jobject");
        assertEquals(type.isDoubleLength(),false);
        assertEquals(type.isFloatingPoint(),false);
    }

    @Test(expected = IllegalPatternException.class)
    public void testUnknownTypeWrongLetter()
    {
        JniType type = new JniType("K");
    }

    @Test(expected = IllegalPatternException.class)
    public void testUnknownTypeMissingObjectSemicolon()
    {
        JniType type = new JniType("Ljava/util/String");
    }

    @Test
    public void testVoid()
    {
        JniType type = new JniType("V");
        assertEquals(type.getName(),"void");
        assertEquals(type.getJniName(),"void");
        assertEquals(type.isDoubleLength(),false);
        assertEquals(type.isFloatingPoint(),false);
    }

    @Test
    public void testShort()
    {
        JniType type = new JniType("S");
        assertEquals(type.getName(),"jshort");
        assertEquals(type.getJniName(),"jshort");
        assertEquals(type.isDoubleLength(),false);
        assertEquals(type.isFloatingPoint(),false);
    }

    @Test
    public void testChar()
    {
        JniType type = new JniType("C");
        assertEquals(type.getName(),"jchar");
        assertEquals(type.getJniName(),"jchar");
        assertEquals(type.isDoubleLength(),false);
        assertEquals(type.isFloatingPoint(),false);
    }

    @Test
    public void testBoolean()
    {
        JniType type = new JniType("Z");
        assertEquals(type.getName(),"jboolean");
        assertEquals(type.getJniName(),"jboolean");
        assertEquals(type.isDoubleLength(),false);
        assertEquals(type.isFloatingPoint(),false);
    }

    @Test
    public void testByte()
    {
        JniType type = new JniType("B");
        assertEquals(type.getName(),"jbyte");
        assertEquals(type.getJniName(),"jbyte");
        assertEquals(type.isDoubleLength(),false);
        assertEquals(type.isFloatingPoint(),false);
    }

    @Test
    public void testLong()
    {
        JniType type = new JniType("J");
        assertEquals(type.getName(),"jlong");
        assertEquals(type.getJniName(),"jlong");
        assertEquals(type.isDoubleLength(),true);
        assertEquals(type.isFloatingPoint(),false);
    }

    @Test
    public void testFloat()
    {
        JniType type = new JniType("F");
        assertEquals(type.getName(),"jfloat");
        assertEquals(type.getJniName(),"jfloat");
        assertEquals(type.isDoubleLength(),false);
        assertEquals(type.isFloatingPoint(),true);
    }

    @Test
    public void testDouble()
    {
        JniType type = new JniType("D");
        assertEquals(type.getName(),"jdouble");
        assertEquals(type.getJniName(),"jdouble");
        assertEquals(type.isDoubleLength(),true);
        assertEquals(type.isFloatingPoint(),true);
    }
}
