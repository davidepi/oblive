package testclasses;

import it.se.obfuscator.Obfuscate;

public class TesterInvokeMethodBoolean
{
    public TesterInvokeMethodBoolean()
    {

    }

    @Obfuscate
    public boolean and(boolean a, boolean b)
    {
        return normalAnd(a,b);
    }
    public boolean normalAnd(boolean a, boolean b)
    {
        return a && b;
    }
}