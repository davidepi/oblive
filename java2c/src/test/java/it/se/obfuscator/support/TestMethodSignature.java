package it.se.obfuscator.support;

import it.se.obfuscator.IllegalPatternException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMethodSignature
{

    @Test
    public void testNoInputVoidReturn()
    {
        MethodSignature ms = new MethodSignature("()V");
        assertEquals(0, ms.getInput().size());
        assertEquals("void", ms.getReturnType().getJniName());
    }

    @Test
    public void testSingleInputVoidReturn()
    {
        MethodSignature ms = new MethodSignature("(I)V");
        assertEquals(1, ms.getInput().size());
        assertEquals("jint", ms.getInput().get(0).getJniName());
        assertEquals("void", ms.getReturnType().getJniName());
    }

    @Test
    public void testIntReturn()
    {
        MethodSignature ms = new MethodSignature("()I");
        assertEquals(0, ms.getInput().size());
        assertEquals("jint", ms.getReturnType().getJniName());
    }

    @Test
    public void testObjectReturn()
    {
        MethodSignature ms = new MethodSignature("()Ljava/lang/String;");
        assertEquals(0, ms.getInput().size());
        assertEquals("jobject", ms.getReturnType().getJniName());
        assertEquals("java/lang/String", ms.getReturnType().getName());
    }

    @Test
    public void testSingleObjectInput()
    {
        MethodSignature ms = new MethodSignature("(Ljava/lang/String;)V");
        assertEquals(1, ms.getInput().size());
        assertEquals("jobject", ms.getInput().get(0).getJniName());
        assertEquals("java/lang/String", ms.getInput().get(0).getName());
        assertEquals("void", ms.getReturnType().getJniName());
    }

    @Test
    public void testMultipleInputs()
    {
        MethodSignature ms = new MethodSignature("(ICBZJDF)V");
        assertEquals(7, ms.getInput().size());
        assertEquals("jint", ms.getInput().get(0).getJniName());
        assertEquals("jchar", ms.getInput().get(1).getJniName());
        assertEquals("jbyte", ms.getInput().get(2).getJniName());
        assertEquals("jboolean", ms.getInput().get(3).getJniName());
        assertEquals("jlong", ms.getInput().get(4).getJniName());
        assertEquals("jdouble", ms.getInput().get(5).getJniName());
        assertEquals("jfloat", ms.getInput().get(6).getJniName());
        assertEquals("void", ms.getReturnType().getJniName());
    }

    @Test
    public void testMultipleObjectInputs()
    {
        MethodSignature ms = new MethodSignature("(Ljava/lang/String;Ljava/util/ArrayList;)V");
        assertEquals(2, ms.getInput().size());
        assertEquals("jobject",ms.getInput().get(0).getJniName());
        assertEquals("java/lang/String", ms.getInput().get(0).getName());
        assertEquals("jobject",ms.getInput().get(1).getJniName());
        assertEquals("java/util/ArrayList",ms.getInput().get(1).getName());
        assertEquals("void", ms.getReturnType().getJniName());
    }

    @Test
    public void testMixedInputs()
    {
        MethodSignature ms = new MethodSignature("(ILjava/lang/String;CLjava/util/ArrayList;B)V");
        assertEquals(5, ms.getInput().size());
        assertEquals("jint", ms.getInput().get(0).getJniName());
        assertEquals("jobject", ms.getInput().get(1).getJniName());
        assertEquals("java/lang/String", ms.getInput().get(1).getName());
        assertEquals("jchar", ms.getInput().get(2).getJniName());
        assertEquals("jobject", ms.getInput().get(3).getJniName());
        assertEquals("java/util/ArrayList", ms.getInput().get(3).getName());
        assertEquals("jbyte", ms.getInput().get(4).getJniName());
        assertEquals("void", ms.getReturnType().getJniName());
    }

    @Test(expected = IllegalPatternException.class)
    public void testMissingOpenParenthesis()
    {
        MethodSignature ms = new MethodSignature("V");
    }

    @Test(expected = IllegalPatternException.class)
    public void testMissingClosedParenthesis()
    {
        MethodSignature ms = new MethodSignature("(IIIIIIIIIIIIIIIIII");
    }

    @Test(expected = IllegalPatternException.class)
    public void testMissingReturnType()
    {
        MethodSignature ms = new MethodSignature("(II)");
    }

    @Test
    public void testEquals()
    {
        MethodSignature ms0 = new MethodSignature("()V");
        MethodSignature ms1 = new MethodSignature("(I)V");
        MethodSignature ms2 = new MethodSignature("(II)V");
        MethodSignature ms3 = new MethodSignature("()S");
        MethodSignature ms4 = new MethodSignature("(ISLjava/lang/String;F)V");
        MethodSignature ms5 = new MethodSignature("(ISLjava/lang/String;F)V");

        assertEquals(false, ms0.equals(null));
        assertEquals(false, ms0.equals(new JniType("V")));

        assertEquals(true, ms4.equals(ms5));
        //different inputs
        assertEquals(false, ms0.equals(ms1));
        assertEquals(false, ms0.equals(ms2));
        //different return type
        assertEquals(false, ms0.equals(ms3));
    }
}
