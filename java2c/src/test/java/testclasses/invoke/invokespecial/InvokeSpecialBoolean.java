package testclasses.invoke.invokespecial;

import it.se.obfuscator.Obfuscate;


public class InvokeSpecialBoolean extends InvokeVirtualBoolean
{
    public InvokeSpecialBoolean()
    {

    }

    @Obfuscate
    @Override
    public boolean and(boolean a, boolean b)
    {
        return super.normalAnd(a,b);
    }

    //wrong method, I want the one of the superclass to be called -> invokespecial
    public boolean normalAnd(boolean a, boolean b)
    {
        return false;
    }
}