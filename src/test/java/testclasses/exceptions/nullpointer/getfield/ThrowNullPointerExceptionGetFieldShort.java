package testclasses.exceptions.nullpointer.getfield;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassShort;

public class ThrowNullPointerExceptionGetFieldShort
{
    public ThrowNullPointerExceptionGetFieldShort()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public short exec(SupportClassShort obj)
    {
        return obj.a;
    }
}
