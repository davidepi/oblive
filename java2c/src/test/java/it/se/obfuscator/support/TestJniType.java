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
        assertEquals("jint", type.getName());
        assertEquals("jint", type.getJniName());
        assertEquals(false, type.isDoubleLength());
        assertEquals(false, type.isFloatingPoint());
    }

    @Test
    public void testObject()
    {
        JniType type = new JniType("Ljava/util/String;");
        assertEquals("java/util/String", type.getName());
        assertEquals("jobject", type.getJniName());
        assertEquals(false, type.isDoubleLength());
        assertEquals(false, type.isFloatingPoint());
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

    @Test(expected = IllegalPatternException.class)
    public void testEmptyObjectName()
    {
        JniType type = new JniType("L;");
    }

    @Test
    public void testVoid()
    {
        JniType type = new JniType("V");
        assertEquals("void", type.getName());
        assertEquals("void", type.getJniName());
        assertEquals(false, type.isDoubleLength());
        assertEquals(false, type.isFloatingPoint());
    }

    @Test
    public void testShort()
    {
        JniType type = new JniType("S");
        assertEquals("jshort", type.getName());
        assertEquals("jshort", type.getJniName());
        assertEquals(false, type.isDoubleLength());
        assertEquals(false, type.isFloatingPoint());
    }

    @Test
    public void testChar()
    {
        JniType type = new JniType("C");
        assertEquals("jchar", type.getName());
        assertEquals("jchar", type.getJniName());
        assertEquals(false, type.isDoubleLength());
        assertEquals(false, type.isFloatingPoint());
    }

    @Test
    public void testBoolean()
    {
        JniType type = new JniType("Z");
        assertEquals("jboolean", type.getName());
        assertEquals("jboolean", type.getJniName());
        assertEquals(false, type.isDoubleLength());
        assertEquals(false, type.isFloatingPoint());
    }

    @Test
    public void testByte()
    {
        JniType type = new JniType("B");
        assertEquals("jbyte", type.getName());
        assertEquals("jbyte", type.getJniName());
        assertEquals(false, type.isDoubleLength());
        assertEquals(false, type.isFloatingPoint());
    }

    @Test
    public void testLong()
    {
        JniType type = new JniType("J");
        assertEquals("jlong", type.getName());
        assertEquals("jlong", type.getJniName());
        assertEquals(true, type.isDoubleLength());
        assertEquals(false, type.isFloatingPoint());
    }

    @Test
    public void testFloat()
    {
        JniType type = new JniType("F");
        assertEquals("jfloat", type.getName());
        assertEquals("jfloat", type.getJniName());
        assertEquals(false, type.isDoubleLength());
        assertEquals(true, type.isFloatingPoint());
    }

    @Test
    public void testDouble()
    {
        JniType type = new JniType("D");
        assertEquals("jdouble", type.getName());
        assertEquals("jdouble", type.getJniName());
        assertEquals(true, type.isDoubleLength());
        assertEquals(true, type.isFloatingPoint());
    }
}
