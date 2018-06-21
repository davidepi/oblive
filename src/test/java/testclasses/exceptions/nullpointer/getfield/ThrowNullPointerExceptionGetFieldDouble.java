package testclasses.exceptions.nullpointer.getfield;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassDouble;

public class ThrowNullPointerExceptionGetFieldDouble
{
    public ThrowNullPointerExceptionGetFieldDouble()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public double exec(SupportClassDouble obj)
    {
        return obj.a;
    }
}
