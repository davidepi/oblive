package testclasses.exceptions.invoke.invokespecial;

import eu.fbk.hardening.annotation.Obfuscation;


public class ThrowInvokeSpecialBoolean extends InvokeVirtualBoolean
{
    public ThrowInvokeSpecialBoolean()
    {

    }

    @Obfuscation
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
