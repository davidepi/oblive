package testclasses.exceptions.nullpointer.getfield;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassDouble;

public class ThrowNullPointerExceptionGetFieldDouble
{
    public ThrowNullPointerExceptionGetFieldDouble()
    {

    }

    @Obfuscation
    public double exec(SupportClassDouble obj)
    {
        return obj.a;
    }
}
