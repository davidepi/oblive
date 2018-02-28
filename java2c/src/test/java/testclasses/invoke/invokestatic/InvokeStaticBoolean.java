package testclasses.invoke.invokestatic;

import it.se.obfuscator.Obfuscate;

public class InvokeStaticBoolean
{
    public InvokeStaticBoolean()
    {

    }

    @Obfuscate
    public boolean and(boolean a, boolean b)
    {
        return normalAnd(a,b);
    }
    public static boolean normalAnd(boolean a, boolean b)
    {
        return a && b;
    }
}