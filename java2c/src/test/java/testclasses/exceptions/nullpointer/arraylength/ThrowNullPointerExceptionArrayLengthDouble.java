package testclasses.exceptions.nullpointer.arraylength;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassDouble;

public class ThrowNullPointerExceptionArrayLengthDouble
{
    public ThrowNullPointerExceptionArrayLengthDouble()
    {

    }

    @Obfuscation
    public int exec(SupportClassDouble obj)
    {
        return obj.b.length;
    }
}
