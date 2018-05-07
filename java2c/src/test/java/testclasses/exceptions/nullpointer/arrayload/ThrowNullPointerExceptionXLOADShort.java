package testclasses.exceptions.nullpointer.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassShort;

public class ThrowNullPointerExceptionXLOADShort
{
    public ThrowNullPointerExceptionXLOADShort()
    {

    }

    @Obfuscation
    public int exec(SupportClassShort obj)
    {
        return obj.b[1];
    }
}
