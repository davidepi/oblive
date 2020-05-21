package it.oblive.support;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMethodSignature {

    @Test
    public void testNoInputVoidReturn() {
        MethodSignature ms = new MethodSignature("()V");
        Assertions.assertEquals(0, ms.getInput().size());
        Assertions.assertEquals("void", ms.getReturnType().getJniName());
    }

    @Test
    public void testSingleInputVoidReturn() {
        MethodSignature ms = new MethodSignature("(I)V");
        Assertions.assertEquals(1, ms.getInput().size());
        Assertions.assertEquals("jint", ms.getInput().get(0).getJniName());
        Assertions.assertEquals("void", ms.getReturnType().getJniName());
    }

    @Test
    public void testIntReturn() {
        MethodSignature ms = new MethodSignature("()I");
        Assertions.assertEquals(0, ms.getInput().size());
        Assertions.assertEquals("jint", ms.getReturnType().getJniName());
    }

    @Test
    public void testObjectReturn() {
        MethodSignature ms = new MethodSignature("()Ljava/lang/String;");
        Assertions.assertEquals(0, ms.getInput().size());
        Assertions.assertEquals("jobject", ms.getReturnType().getJniName());
        Assertions.assertEquals("java/lang/String", ms.getReturnType().getName());
    }

    @Test
    public void testSingleObjectInput() {
        MethodSignature ms = new MethodSignature("(Ljava/lang/String;)V");
        Assertions.assertEquals(1, ms.getInput().size());
        Assertions.assertEquals("jobject", ms.getInput().get(0).getJniName());
        Assertions.assertEquals("java/lang/String", ms.getInput().get(0).getName());
        Assertions.assertEquals("void", ms.getReturnType().getJniName());
    }

    @Test
    public void testMultipleInputs() {
        MethodSignature ms = new MethodSignature("(ICBZJDF)V");
        Assertions.assertEquals(7, ms.getInput().size());
        Assertions.assertEquals("jint", ms.getInput().get(0).getJniName());
        Assertions.assertEquals("jchar", ms.getInput().get(1).getJniName());
        Assertions.assertEquals("jbyte", ms.getInput().get(2).getJniName());
        Assertions.assertEquals("jboolean", ms.getInput().get(3).getJniName());
        Assertions.assertEquals("jlong", ms.getInput().get(4).getJniName());
        Assertions.assertEquals("jdouble", ms.getInput().get(5).getJniName());
        Assertions.assertEquals("jfloat", ms.getInput().get(6).getJniName());
        Assertions.assertEquals("void", ms.getReturnType().getJniName());
    }

    @Test
    public void testMultipleObjectInputs() {
        MethodSignature ms = new MethodSignature("(Ljava/lang/String;Ljava/util/ArrayList;)V");
        Assertions.assertEquals(2, ms.getInput().size());
        Assertions.assertEquals("jobject", ms.getInput().get(0).getJniName());
        Assertions.assertEquals("java/lang/String", ms.getInput().get(0).getName());
        Assertions.assertEquals("jobject", ms.getInput().get(1).getJniName());
        Assertions.assertEquals("java/util/ArrayList", ms.getInput().get(1).getName());
        Assertions.assertEquals("void", ms.getReturnType().getJniName());
    }

    @Test
    public void testMixedInputs() {
        MethodSignature ms = new MethodSignature("(ILjava/lang/String;CLjava/util/ArrayList;B)V");
        Assertions.assertEquals(5, ms.getInput().size());
        Assertions.assertEquals("jint", ms.getInput().get(0).getJniName());
        Assertions.assertEquals("jobject", ms.getInput().get(1).getJniName());
        Assertions.assertEquals("java/lang/String", ms.getInput().get(1).getName());
        Assertions.assertEquals("jchar", ms.getInput().get(2).getJniName());
        Assertions.assertEquals("jobject", ms.getInput().get(3).getJniName());
        Assertions.assertEquals("java/util/ArrayList", ms.getInput().get(3).getName());
        Assertions.assertEquals("jbyte", ms.getInput().get(4).getJniName());
        Assertions.assertEquals("void", ms.getReturnType().getJniName());
    }

    @Test
    public void testMissingOpenParenthesis() {
        Assertions.assertThrows(IllegalPatternError.class, () -> {
            MethodSignature ms = new MethodSignature("V");
        });
    }

    @Test
    public void testMissingClosedParenthesis() {
        Assertions.assertThrows(IllegalPatternError.class, () -> {
            MethodSignature ms = new MethodSignature("(IIIIIIIIIIIIIIIIII");
        });
    }

    @Test
    public void testMalformedObjectInput() {
        Assertions.assertThrows(IllegalPatternError.class, () -> {
            MethodSignature ms = new MethodSignature("(Ljava/lang)V");
        });
    }

    @Test
    public void testMalformedObjectReturn() {
        Assertions.assertThrows(IllegalPatternError.class, () -> {
            MethodSignature ms = new MethodSignature("(I)Ljava/lang");
        });
    }

    @Test
    public void testEquals() {
        MethodSignature ms0 = new MethodSignature("()V");
        MethodSignature ms1 = new MethodSignature("(I)V");
        MethodSignature ms2 = new MethodSignature("(II)V");
        MethodSignature ms3 = new MethodSignature("()S");
        MethodSignature ms4 = new MethodSignature("(ISLjava/lang/String;F)V");
        MethodSignature ms5 = new MethodSignature("(ISLjava/lang/String;F)V");

        Assertions.assertNotEquals(null, ms0);
        Assertions.assertNotEquals(ms0, new JniType("V"));

        Assertions.assertEquals(ms4, ms5);
        //different inputs
        Assertions.assertNotEquals(ms0, ms1);
        Assertions.assertNotEquals(ms0, ms2);
        //different return type
        Assertions.assertNotEquals(ms0, ms3);
    }

    @Test
    public void testMissingReturnType() {
        Assertions.assertThrows(IllegalPatternError.class, () -> {
            MethodSignature ms = new MethodSignature("(II)");
        });
    }

    @Test
    public void testSingleIntArrayReturn() {
        MethodSignature ms = new MethodSignature("()[I");
        Assertions.assertEquals(0, ms.getInput().size());
        Assertions.assertEquals("jobject", ms.getReturnType().getJniName());
        Assertions.assertEquals(1, ms.getReturnType().getArrayDepth());
    }

    @Test
    public void testMultidimensionalIntArrayReturn() {
        MethodSignature ms = new MethodSignature("()[[[[I");
        Assertions.assertEquals(0, ms.getInput().size());
        Assertions.assertEquals("jobject", ms.getReturnType().getJniName());
        Assertions.assertEquals(4, ms.getReturnType().getArrayDepth());
    }

    @Test
    public void testMixedInputsArrays() {
        MethodSignature ms = new MethodSignature("(I[Ljava/lang/String;[[CLjava/util/ArrayList;[[[B)V");
        Assertions.assertEquals(5, ms.getInput().size());
        Assertions.assertEquals("jint", ms.getInput().get(0).getJniName());
        Assertions.assertEquals(0, ms.getInput().get(0).getArrayDepth());
        Assertions.assertEquals("jobject", ms.getInput().get(1).getJniName());
        Assertions.assertEquals("java/lang/String", ms.getInput().get(1).getName());
        Assertions.assertEquals(1, ms.getInput().get(1).getArrayDepth());
        Assertions.assertEquals("jobject", ms.getInput().get(2).getJniName());
        Assertions.assertEquals("jchar", ms.getInput().get(2).getName());
        Assertions.assertEquals(2, ms.getInput().get(2).getArrayDepth());
        Assertions.assertEquals("jobject", ms.getInput().get(3).getJniName());
        Assertions.assertEquals("java/util/ArrayList", ms.getInput().get(3).getName());
        Assertions.assertEquals(0, ms.getInput().get(3).getArrayDepth());
        Assertions.assertEquals("jbyte", ms.getInput().get(4).getName());
        Assertions.assertEquals("jobject", ms.getInput().get(4).getJniName());
        Assertions.assertEquals(3, ms.getInput().get(4).getArrayDepth());
        Assertions.assertEquals("void", ms.getReturnType().getJniName());
    }

    @Test
    public void testWrongArrayParamAsInput() {
        Assertions.assertThrows(IllegalPatternError.class, () -> {
            MethodSignature ms = new MethodSignature("([[[)I");
        });

    }

    @Test
    public void testReturnWrongArray() {
        Assertions.assertThrows(IllegalPatternError.class, () -> {
            MethodSignature ms = new MethodSignature("(I)[");
        });
    }
}
