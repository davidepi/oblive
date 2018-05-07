package testclasses.exceptions.invoke.invokevirtual;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowInvokeVirtualBoolean
{
    public ThrowInvokeVirtualBoolean()
    {

    }

    @Obfuscation
    public int div(int a)
    {
        return normalDiv(a,0)?0:-1;
    }

    public boolean normalDiv(int a, int b)
    {
        return (a / b)>0;
    }
}