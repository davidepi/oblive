package testclasses.exceptions.invoke.invokestatic;

import it.se.obfuscator.Obfuscate;

public class ThrowInvokeStaticBoolean
{
    public ThrowInvokeStaticBoolean()
    {

    }

    @Obfuscate
    public int div(int a)
    {
        return normalDiv(a,0)?0:-1;
    }

    public static boolean normalDiv(int a, int b)
    {
        return (a / b)>0;
    }
}
