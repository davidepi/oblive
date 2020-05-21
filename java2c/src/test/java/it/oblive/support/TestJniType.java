package it.oblive.support;


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

    @Test
    public void testClassNonPrimitive() {
        Class<?> class0 = StringBuilder.class;
        Class<?> class1 = System[].class;

        String string0 = "Ljava/lang/StringBuilder;";
        String string1 = "[Ljava/lang/System;";

        JniType jnic0 = new JniType(class0);
        JniType jnic1 = new JniType(class1);

        JniType jnis0 = new JniType(string0);
        JniType jnis1 = new JniType(string1);

        Assertions.assertEquals(jnis0, jnic0);
        Assertions.assertEquals(jnis1, jnic1);
    }

    @Test
    public void testClassPrimitive() {
        Class<?> class0 = int.class;
        Class<?> class1 = void.class;
        Class<?> class2 = boolean.class;
        Class<?> class3 = byte.class;
        Class<?> class4 = char.class;
        Class<?> class5 = short.class;
        Class<?> class6 = long.class;
        Class<?> class7 = float.class;
        Class<?> class8 = double.class;
        Class<?> class9 = double[][][].class;

        String string0 = "I";
        String string1 = "V";
        String string2 = "Z";
        String string3 = "B";
        String string4 = "C";
        String string5 = "S";
        String string6 = "J";
        String string7 = "F";
        String string8 = "D";
        String string9 = "[[[D";

        JniType jnic0 = new JniType(class0);
        JniType jnic1 = new JniType(class1);
        JniType jnic2 = new JniType(class2);
        JniType jnic3 = new JniType(class3);
        JniType jnic4 = new JniType(class4);
        JniType jnic5 = new JniType(class5);
        JniType jnic6 = new JniType(class6);
        JniType jnic7 = new JniType(class7);
        JniType jnic8 = new JniType(class8);
        JniType jnic9 = new JniType(class9);

        JniType jnis0 = new JniType(string0);
        JniType jnis1 = new JniType(string1);
        JniType jnis2 = new JniType(string2);
        JniType jnis3 = new JniType(string3);
        JniType jnis4 = new JniType(string4);
        JniType jnis5 = new JniType(string5);
        JniType jnis6 = new JniType(string6);
        JniType jnis7 = new JniType(string7);
        JniType jnis8 = new JniType(string8);
        JniType jnis9 = new JniType(string9);

        Assertions.assertEquals(jnis0, jnic0);
        Assertions.assertEquals(jnis1, jnic1);
        Assertions.assertEquals(jnis2, jnic2);
        Assertions.assertEquals(jnis3, jnic3);
        Assertions.assertEquals(jnis4, jnic4);
        Assertions.assertEquals(jnis5, jnic5);
        Assertions.assertEquals(jnis6, jnic6);
        Assertions.assertEquals(jnis7, jnic7);
        Assertions.assertEquals(jnis8, jnic8);
        Assertions.assertEquals(jnis9, jnic9);
    }

    @Test
    public void testGetInternalRepresentation() {
        String repr0 = "I";
        String repr1 = "[Ljava/lang/String;";
        String repr2 = "[[[D";
        JniType type0 = new JniType(repr0);
        JniType type1 = new JniType(repr1);
        JniType type2 = new JniType(repr2);

        Assertions.assertEquals(repr0, type0.getInternalRepresentation());
        Assertions.assertEquals(repr1, type1.getInternalRepresentation());
        Assertions.assertEquals(repr2, type2.getInternalRepresentation());
    }
}
