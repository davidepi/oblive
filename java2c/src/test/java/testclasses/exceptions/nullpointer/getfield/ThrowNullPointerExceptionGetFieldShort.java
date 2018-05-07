package testclasses.exceptions.nullpointer.getfield;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassShort;

public class ThrowNullPointerExceptionGetFieldShort
{
    public ThrowNullPointerExceptionGetFieldShort()
    {

    }

    @Obfuscation
    public short exec(SupportClassShort obj)
    {
        return obj.a;
    }
}
