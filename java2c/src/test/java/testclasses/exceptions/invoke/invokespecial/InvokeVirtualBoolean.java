package testclasses.exceptions.invoke.invokespecial;

import it.se.obfuscator.Obfuscate;

public class InvokeVirtualBoolean
{
    public InvokeVirtualBoolean()
    {

    }

    @Obfuscate
    public boolean and(boolean a, boolean b)
    {
        return normalAnd(a,b);
    }
    public boolean normalAnd(boolean a, boolean b)
    {
        int c = 1/0;
        return true;
    }
}