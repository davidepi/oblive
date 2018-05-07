package eu.fbk.hardening.support;

import eu.fbk.hardening.IllegalPatternException;
import eu.fbk.hardening.IllegalPatternException;
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
        assertEquals('i', type.getJvalueLetter());
        assertEquals(false, type.isDoubleLength());
        assertEquals(false, type.isFloatingPoint());
        assertEquals(0, type.getArrayDepth());
    }

    @Test
    public void testObject()
    {
        JniType type = new JniType("Ljava/util/String;");
        assertEquals("java/util/String", type.getName());
        assertEquals("jobject", type.getJniName());
        assertEquals('l', type.getJvalueLetter());
        assertEquals(false, type.isDoubleLength());
        assertEquals(false, type.isFloatingPoint());
        assertEquals(0, type.getArrayDepth());
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

    @Test(expected = IllegalPatternException.class)
    public void testUntypedArray()
    {
        JniType type = new JniType("[");
    }

    @Test
    public void testVoid()
    {
        JniType type = new JniType("V");
        assertEquals("void", type.getName());
        assertEquals("void", type.getJniName());
        assertEquals(false, type.isDoubleLength());
        assertEquals(false, type.isFloatingPoint());
        assertEquals(0, type.getArrayDepth());
    }

    @Test
    public void testShort()
    {
        JniType type = new JniType("S");
        assertEquals("jshort", type.getName());
        assertEquals("jshort", type.getJniName());
        assertEquals('s', type.getJvalueLetter());
        assertEquals(false, type.isDoubleLength());
        assertEquals(false, type.isFloatingPoint());
        assertEquals(0, type.getArrayDepth());
    }

    @Test
    public void testChar()
    {
        JniType type = new JniType("C");
        assertEquals("jchar", type.getName());
        assertEquals("jchar", type.getJniName());
        assertEquals('c', type.getJvalueLetter());
        assertEquals(false, type.isDoubleLength());
        assertEquals(false, type.isFloatingPoint());
        assertEquals(0, type.getArrayDepth());
    }

    @Test
    public void testBoolean()
    {
        JniType type = new JniType("Z");
        assertEquals("jboolean", type.getName());
        assertEquals("jboolean", type.getJniName());
        assertEquals('z', type.getJvalueLetter());
        assertEquals(false, type.isDoubleLength());
        assertEquals(false, type.isFloatingPoint());
        assertEquals(0, type.getArrayDepth());
    }

    @Test
    public void testByte()
    {
        JniType type = new JniType("B");
        assertEquals("jbyte", type.getName());
        assertEquals("jbyte", type.getJniName());
        assertEquals('b', type.getJvalueLetter());
        assertEquals(false, type.isDoubleLength());
        assertEquals(false, type.isFloatingPoint());
        assertEquals(0, type.getArrayDepth());
    }

    @Test
    public void testLong()
    {
        JniType type = new JniType("J");
        assertEquals("jlong", type.getName());
        assertEquals("jlong", type.getJniName());
        assertEquals('j', type.getJvalueLetter());
        assertEquals(true, type.isDoubleLength());
        assertEquals(false, type.isFloatingPoint());
        assertEquals(0, type.getArrayDepth());
    }

    @Test
    public void testFloat()
    {
        JniType type = new JniType("F");
        assertEquals("jfloat", type.getName());
        assertEquals("jfloat", type.getJniName());
        assertEquals('f', type.getJvalueLetter());
        assertEquals(false, type.isDoubleLength());
        assertEquals(true, type.isFloatingPoint());
        assertEquals(0, type.getArrayDepth());
    }

    @Test
    public void testDouble()
    {
        JniType type = new JniType("D");
        assertEquals("jdouble", type.getName());
        assertEquals("jdouble", type.getJniName());
        assertEquals('d', type.getJvalueLetter());
        assertEquals(true, type.isDoubleLength());
        assertEquals(true, type.isFloatingPoint());
        assertEquals(0, type.getArrayDepth());
    }

    @Test
    public void testArraySingleDim()
    {
        JniType type = new JniType("[I");
        assertEquals("jint", type.getName());
        assertEquals("jobject", type.getJniName());
        assertEquals('l', type.getJvalueLetter());
        assertEquals(false, type.isDoubleLength());
        assertEquals(false, type.isFloatingPoint());
        assertEquals(1, type.getArrayDepth());
    }

    @Test
    public void testMultidimensionalArray()
    {
        JniType type = new JniType("[[[Ljava/util/String;");
        assertEquals("java/util/String", type.getName());
        assertEquals("jobject", type.getJniName());
        assertEquals('l', type.getJvalueLetter());
        assertEquals(false, type.isDoubleLength());
        assertEquals(false, type.isFloatingPoint());
        assertEquals(3, type.getArrayDepth());
    }

    @Test
    public void testEquals()
    {
        JniType voidt0 = new JniType("V");
        JniType voidt1 = new JniType("V");
        JniType intt0 = new JniType("I");
        JniType intt1 = new JniType("I");
        JniType chart0 = new JniType("C");
        JniType chart1 = new JniType("C");
        JniType bytet0 = new JniType("B");
        JniType bytet1 = new JniType("B");
        JniType booleant0 = new JniType("Z");
        JniType booleant1 = new JniType("Z");
        JniType shortt0 = new JniType("S");
        JniType shortt1 = new JniType("S");
        JniType longt0 = new JniType("J");
        JniType longt1 = new JniType("J");
        JniType floatt0 = new JniType("F");
        JniType floatt1 = new JniType("F");
        JniType doublet0 = new JniType("D");
        JniType doublet1 = new JniType("D");
        JniType objectt0 = new JniType("Ljava/lang/String;");
        JniType objectt1 = new JniType("Ljava/lang/String;");
        JniType objectt2 = new JniType("Ljava/lang/StringBuilder;");

        assertEquals(false,voidt0.equals(null));
        assertEquals(false,voidt0.equals(new MethodSignature("()V")));

        assertEquals(true, voidt0.equals(voidt1));
        assertEquals(false, voidt0.equals(objectt2));
        assertEquals(true, intt0.equals(intt1));
        assertEquals(false, intt0.equals(objectt2));
        assertEquals(true, chart0.equals(chart1));
        assertEquals(false, chart0.equals(objectt2));
        assertEquals(true, bytet0.equals(bytet1));
        assertEquals(false, bytet0.equals(objectt2));
        assertEquals(true, booleant0.equals(booleant1));
        assertEquals(false, booleant0.equals(objectt2));
        assertEquals(true, shortt0.equals(shortt1));
        assertEquals(false, shortt0.equals(objectt2));
        assertEquals(true, longt0.equals(longt1));
        assertEquals(false, longt0.equals(objectt2));
        assertEquals(true, floatt0.equals(floatt1));
        assertEquals(false, floatt0.equals(objectt2));
        assertEquals(true, doublet0.equals(doublet1));
        assertEquals(false, doublet0.equals(objectt2));
        assertEquals(true, objectt0.equals(objectt1));
        assertEquals(false, objectt0.equals(objectt2));

    }
}
