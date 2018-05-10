package testclasses.exceptions.nullpointer.setfield;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassDouble;

public class ThrowNullPointerExceptionSetFieldDouble
{
    public ThrowNullPointerExceptionSetFieldDouble()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public double exec(SupportClassDouble obj)
    {
        obj.a = 0;
        return 0;
    }
}
