package testclasses.exceptions.nullpointer.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassDouble;

public class ThrowNullPointerExceptionXLOADDouble
{
    public ThrowNullPointerExceptionXLOADDouble()
    {

    }

    @Obfuscation
    public int exec(SupportClassDouble obj)
    {
        return (int)obj.b[1];
    }
}
