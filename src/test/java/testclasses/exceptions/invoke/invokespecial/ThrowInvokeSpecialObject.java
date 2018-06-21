package testclasses.exceptions.invoke.invokespecial;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowInvokeSpecialObject extends InvokeVirtualObject
{
    public ThrowInvokeSpecialObject()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    @Override
    public String concatenate(String a, char b)
    {
        return super.normalcat(a, b);
    }

    //wrong method, I want the one of the superclass to be called -> invokespecial
    public String normalcat(String a, char b)
    {
        return "WRONG INVOKESPECIAL!";
    }
}
