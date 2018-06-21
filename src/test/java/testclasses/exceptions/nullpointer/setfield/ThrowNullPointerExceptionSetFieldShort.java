package testclasses.exceptions.nullpointer.setfield;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassShort;

public class ThrowNullPointerExceptionSetFieldShort
{
    public ThrowNullPointerExceptionSetFieldShort()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public short exec(SupportClassShort obj)
    {
        obj.a = 0;
        return 0;
    }
}
