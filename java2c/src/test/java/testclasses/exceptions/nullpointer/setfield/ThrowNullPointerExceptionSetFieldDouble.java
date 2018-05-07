package testclasses.exceptions.nullpointer.setfield;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassDouble;

public class ThrowNullPointerExceptionSetFieldDouble
{
    public ThrowNullPointerExceptionSetFieldDouble()
    {

    }

    @Obfuscation
    public double exec(SupportClassDouble obj)
    {
        obj.a = 0;
        return 0;
    }
}
