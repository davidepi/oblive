package eu.fbk.hardening.support;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestJniType {
    @Test
    public void testInteger() {
        JniType type = new JniType("I");
        assertEquals("jint", type.getName());
        assertEquals("jint", type.getJniName());
        assertEquals('i', type.getJvalueLetter());
        assertFalse(type.isDoubleLength());
        assertFalse(type.isFloatingPoint());
        assertEquals(0, type.getArrayDepth());
        assertEquals("I", type.getOverloadName());
    }

    @Test
    public void testObject() {
        JniType type = new JniType("Ljava/util/String;");
        assertEquals("java/util/String", type.getName());
        assertEquals("jobject", type.getJniName());
        assertEquals('l', type.getJvalueLetter());
        assertFalse(type.isDoubleLength());
        assertFalse(type.isFloatingPoint());
        assertEquals(0, type.getArrayDepth());
        assertEquals("Ljava_util_String_2", type.getOverloadName());
    }

    @Test(expected = IllegalPatternError.class)
    public void testUnknownTypeWrongLetter() {
        JniType type = new JniType("K");
    }

    @Test(expected = IllegalPatternError.class)
    public void testUnknownTypeMissingObjectSemicolon() {
        JniType type = new JniType("Ljava/util/String");
    }

    @Test(expected = IllegalPatternError.class)
    public void testEmptyObjectName() {
        JniType type = new JniType("L;");
    }

    @Test(expected = IllegalPatternError.class)
    public void testUntypedArray() {
        JniType type = new JniType("[");
    }

    @Test
    public void testVoid() {
        JniType type = new JniType("V");
        assertEquals("void", type.getName());
        assertEquals("void", type.getJniName());
        assertFalse(type.isDoubleLength());
        assertFalse(type.isFloatingPoint());
        assertEquals(0, type.getArrayDepth());
        assertEquals("", type.getOverloadName());
    }

    @Test
    public void testShort() {
        JniType type = new JniType("S");
        assertEquals("jshort", type.getName());
        assertEquals("jshort", type.getJniName());
        assertEquals('s', type.getJvalueLetter());
        assertFalse(type.isDoubleLength());
        assertFalse(type.isFloatingPoint());
        assertEquals(0, type.getArrayDepth());
        assertEquals("S", type.getOverloadName());
    }

    @Test
    public void testChar() {
        JniType type = new JniType("C");
        assertEquals("jchar", type.getName());
        assertEquals("jchar", type.getJniName());
        assertEquals('c', type.getJvalueLetter());
        assertFalse(type.isDoubleLength());
        assertFalse(type.isFloatingPoint());
        assertEquals(0, type.getArrayDepth());
        assertEquals("C", type.getOverloadName());
    }

    @Test
    public void testBoolean() {
        JniType type = new JniType("Z");
        assertEquals("jboolean", type.getName());
        assertEquals("jboolean", type.getJniName());
        assertEquals('z', type.getJvalueLetter());
        assertFalse(type.isDoubleLength());
        assertFalse(type.isFloatingPoint());
        assertEquals(0, type.getArrayDepth());
        assertEquals("Z", type.getOverloadName());
    }

    @Test
    public void testByte() {
        JniType type = new JniType("B");
        assertEquals("jbyte", type.getName());
        assertEquals("jbyte", type.getJniName());
        assertEquals('b', type.getJvalueLetter());
        assertFalse(type.isDoubleLength());
        assertFalse(type.isFloatingPoint());
        assertEquals(0, type.getArrayDepth());
        assertEquals("B", type.getOverloadName());
    }

    @Test
    public void testLong() {
        JniType type = new JniType("J");
        assertEquals("jlong", type.getName());
        assertEquals("jlong", type.getJniName());
        assertEquals('j', type.getJvalueLetter());
        assertTrue(type.isDoubleLength());
        assertFalse(type.isFloatingPoint());
        assertEquals(0, type.getArrayDepth());
        assertEquals("J", type.getOverloadName());
    }

    @Test
    public void testFloat() {
        JniType type = new JniType("F");
        assertEquals("jfloat", type.getName());
        assertEquals("jfloat", type.getJniName());
        assertEquals('f', type.getJvalueLetter());
        assertFalse(type.isDoubleLength());
        assertTrue(type.isFloatingPoint());
        assertEquals(0, type.getArrayDepth());
        assertEquals("F", type.getOverloadName());
    }

    @Test
    public void testDouble() {
        JniType type = new JniType("D");
        assertEquals("jdouble", type.getName());
        assertEquals("jdouble", type.getJniName());
        assertEquals('d', type.getJvalueLetter());
        assertTrue(type.isDoubleLength());
        assertTrue(type.isFloatingPoint());
        assertEquals(0, type.getArrayDepth());
        assertEquals("D", type.getOverloadName());
    }

    @Test
    public void testArraySingleDim() {
        JniType type = new JniType("[I");
        assertEquals("jint", type.getName());
        assertEquals("jobject", type.getJniName());
        assertEquals('l', type.getJvalueLetter());
        assertFalse(type.isDoubleLength());
        assertFalse(type.isFloatingPoint());
        assertEquals(1, type.getArrayDepth());
        assertEquals("_3I", type.getOverloadName());
    }

    @Test
    public void testMultidimensionalArray() {
        JniType type = new JniType("[[[Ljava/util/String;");
        assertEquals("java/util/String", type.getName());
        assertEquals("jobject", type.getJniName());
        assertEquals('l', type.getJvalueLetter());
        assertFalse(type.isDoubleLength());
        assertFalse(type.isFloatingPoint());
        assertEquals(3, type.getArrayDepth());
        assertEquals("_3_3_3Ljava_util_String_2", type.getOverloadName());
    }

    @Test
    public void testEquals() {
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

        assertNotEquals(null, voidt0);
        assertNotEquals(voidt0, new MethodSignature("()V"));

        assertEquals(voidt0, voidt1);
        assertNotEquals(voidt0, objectt2);
        assertEquals(intt0, intt1);
        assertNotEquals(intt0, objectt2);
        assertEquals(chart0, chart1);
        assertNotEquals(chart0, objectt2);
        assertEquals(bytet0, bytet1);
        assertNotEquals(bytet0, objectt2);
        assertEquals(booleant0, booleant1);
        assertNotEquals(booleant0, objectt2);
        assertEquals(shortt0, shortt1);
        assertNotEquals(shortt0, objectt2);
        assertEquals(longt0, longt1);
        assertNotEquals(longt0, objectt2);
        assertEquals(floatt0, floatt1);
        assertNotEquals(floatt0, objectt2);
        assertEquals(doublet0, doublet1);
        assertNotEquals(doublet0, objectt2);
        assertEquals(objectt0, objectt1);
        assertNotEquals(objectt0, objectt2);
    }
}
