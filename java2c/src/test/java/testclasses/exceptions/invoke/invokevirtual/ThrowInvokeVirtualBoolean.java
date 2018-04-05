package testclasses.exceptions.invoke.invokevirtual;

import it.se.obfuscator.Obfuscate;

public class ThrowInvokeVirtualBoolean
{
    public ThrowInvokeVirtualBoolean()
    {

    }

    @Obfuscate
    public int div(int a)
    {
        return normalDiv(a,0)?0:-1;
    }

    public boolean normalDiv(int a, int b)
    {
        return (a / b)>0;
    }
}