package eu.fbk.hardening.support;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestJniType {
    @Test
    public void testInteger() {
        JniType type = new JniType("I");
        Assertions.assertEquals("jint", type.getName());
        Assertions.assertEquals("jint", type.getJniName());
        Assertions.assertEquals('i', type.getJvalueLetter());
        Assertions.assertFalse(type.isDoubleLength());
        Assertions.assertFalse(type.isFloatingPoint());
        Assertions.assertEquals(0, type.getArrayDepth());
        Assertions.assertEquals("I", type.getOverloadName());
    }

    @Test
    public void testObject() {
        JniType type = new JniType("Ljava/util/String;");
        Assertions.assertEquals("java/util/String", type.getName());
        Assertions.assertEquals("jobject", type.getJniName());
        Assertions.assertEquals('l', type.getJvalueLetter());
        Assertions.assertFalse(type.isDoubleLength());
        Assertions.assertFalse(type.isFloatingPoint());
        Assertions.assertEquals(0, type.getArrayDepth());
        Assertions.assertEquals("Ljava_util_String_2", type.getOverloadName());
    }

    @Test
    public void testUnknownTypeWrongLetter() {
        Assertions.assertThrows(IllegalPatternError.class, () -> {
            JniType type = new JniType("K");
        });
    }

    @Test
    public void testUnknownTypeMissingObjectSemicolon() {
        Assertions.assertThrows(IllegalPatternError.class, () -> {
            JniType type = new JniType("Ljava/util/String");
        });
    }

    @Test
    public void testEmptyObjectName() {
        Assertions.assertThrows(IllegalPatternError.class, () -> {
            JniType type = new JniType("L;");
        });
    }

    @Test
    public void testUntypedArray() {
        Assertions.assertThrows(IllegalPatternError.class, () -> {
            JniType type = new JniType("[");
        });
    }

    @Test
    public void testVoid() {
        JniType type = new JniType("V");
        Assertions.assertEquals("void", type.getName());
        Assertions.assertEquals("void", type.getJniName());
        Assertions.assertFalse(type.isDoubleLength());
        Assertions.assertFalse(type.isFloatingPoint());
        Assertions.assertEquals(0, type.getArrayDepth());
        Assertions.assertEquals("", type.getOverloadName());
    }

    @Test
    public void testShort() {
        JniType type = new JniType("S");
        Assertions.assertEquals("jshort", type.getName());
        Assertions.assertEquals("jshort", type.getJniName());
        Assertions.assertEquals('s', type.getJvalueLetter());
        Assertions.assertFalse(type.isDoubleLength());
        Assertions.assertFalse(type.isFloatingPoint());
        Assertions.assertEquals(0, type.getArrayDepth());
        Assertions.assertEquals("S", type.getOverloadName());
    }

    @Test
    public void testChar() {
        JniType type = new JniType("C");
        Assertions.assertEquals("jchar", type.getName());
        Assertions.assertEquals("jchar", type.getJniName());
        Assertions.assertEquals('c', type.getJvalueLetter());
        Assertions.assertFalse(type.isDoubleLength());
        Assertions.assertFalse(type.isFloatingPoint());
        Assertions.assertEquals(0, type.getArrayDepth());
        Assertions.assertEquals("C", type.getOverloadName());
    }

    @Test
    public void testBoolean() {
        JniType type = new JniType("Z");
        Assertions.assertEquals("jboolean", type.getName());
        Assertions.assertEquals("jboolean", type.getJniName());
        Assertions.assertEquals('z', type.getJvalueLetter());
        Assertions.assertFalse(type.isDoubleLength());
        Assertions.assertFalse(type.isFloatingPoint());
        Assertions.assertEquals(0, type.getArrayDepth());
        Assertions.assertEquals("Z", type.getOverloadName());
    }

    @Test
    public void testByte() {
        JniType type = new JniType("B");
        Assertions.assertEquals("jbyte", type.getName());
        Assertions.assertEquals("jbyte", type.getJniName());
        Assertions.assertEquals('b', type.getJvalueLetter());
        Assertions.assertFalse(type.isDoubleLength());
        Assertions.assertFalse(type.isFloatingPoint());
        Assertions.assertEquals(0, type.getArrayDepth());
        Assertions.assertEquals("B", type.getOverloadName());
    }

    @Test
    public void testLong() {
        JniType type = new JniType("J");
        Assertions.assertEquals("jlong", type.getName());
        Assertions.assertEquals("jlong", type.getJniName());
        Assertions.assertEquals('j', type.getJvalueLetter());
        Assertions.assertTrue(type.isDoubleLength());
        Assertions.assertFalse(type.isFloatingPoint());
        Assertions.assertEquals(0, type.getArrayDepth());
        Assertions.assertEquals("J", type.getOverloadName());
    }

    @Test
    public void testFloat() {
        JniType type = new JniType("F");
        Assertions.assertEquals("jfloat", type.getName());
        Assertions.assertEquals("jfloat", type.getJniName());
        Assertions.assertEquals('f', type.getJvalueLetter());
        Assertions.assertFalse(type.isDoubleLength());
        Assertions.assertTrue(type.isFloatingPoint());
        Assertions.assertEquals(0, type.getArrayDepth());
        Assertions.assertEquals("F", type.getOverloadName());
    }

    @Test
    public void testDouble() {
        JniType type = new JniType("D");
        Assertions.assertEquals("jdouble", type.getName());
        Assertions.assertEquals("jdouble", type.getJniName());
        Assertions.assertEquals('d', type.getJvalueLetter());
        Assertions.assertTrue(type.isDoubleLength());
        Assertions.assertTrue(type.isFloatingPoint());
        Assertions.assertEquals(0, type.getArrayDepth());
        Assertions.assertEquals("D", type.getOverloadName());
    }

    @Test
    public void testArraySingleDim() {
        JniType type = new JniType("[I");
        Assertions.assertEquals("jint", type.getName());
        Assertions.assertEquals("jobject", type.getJniName());
        Assertions.assertEquals('l', type.getJvalueLetter());
        Assertions.assertFalse(type.isDoubleLength());
        Assertions.assertFalse(type.isFloatingPoint());
        Assertions.assertEquals(1, type.getArrayDepth());
        Assertions.assertEquals("_3I", type.getOverloadName());
    }

    @Test
    public void testMultidimensionalArray() {
        JniType type = new JniType("[[[Ljava/util/String;");
        Assertions.assertEquals("java/util/String", type.getName());
        Assertions.assertEquals("jobject", type.getJniName());
        Assertions.assertEquals('l', type.getJvalueLetter());
        Assertions.assertFalse(type.isDoubleLength());
        Assertions.assertFalse(type.isFloatingPoint());
        Assertions.assertEquals(3, type.getArrayDepth());
        Assertions.assertEquals("_3_3_3Ljava_util_String_2", type.getOverloadName());
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

        Assertions.assertNotEquals(null, voidt0);
        Assertions.assertNotEquals(voidt0, new MethodSignature("()V"));

        Assertions.assertEquals(voidt0, voidt1);
        Assertions.assertNotEquals(voidt0, objectt2);
        Assertions.assertEquals(intt0, intt1);
        Assertions.assertNotEquals(intt0, objectt2);
        Assertions.assertEquals(chart0, chart1);
        Assertions.assertNotEquals(chart0, objectt2);
        Assertions.assertEquals(bytet0, bytet1);
        Assertions.assertNotEquals(bytet0, objectt2);
        Assertions.assertEquals(booleant0, booleant1);
        Assertions.assertNotEquals(booleant0, objectt2);
        Assertions.assertEquals(shortt0, shortt1);
        Assertions.assertNotEquals(shortt0, objectt2);
        Assertions.assertEquals(longt0, longt1);
        Assertions.assertNotEquals(longt0, objectt2);
        Assertions.assertEquals(floatt0, floatt1);
        Assertions.assertNotEquals(floatt0, objectt2);
        Assertions.assertEquals(doublet0, doublet1);
        Assertions.assertNotEquals(doublet0, objectt2);
        Assertions.assertEquals(objectt0, objectt1);
        Assertions.assertNotEquals(objectt0, objectt2);
    }
}
