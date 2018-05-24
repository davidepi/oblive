package testclasses.invoke.invokespecial;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;


public class InvokeSpecialCastBoolean extends InvokeVirtualCastBoolean
{
    public InvokeSpecialCastBoolean()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    @Override
    public boolean and(boolean a, boolean b)
    {
        return super.normalAnd(a, b)==a&&b;
    }

    //wrong method, I want the one of the superclass to be called -> invokespecial
    public boolean normalAnd(boolean a, boolean b)
    {
        return false;
    }
}