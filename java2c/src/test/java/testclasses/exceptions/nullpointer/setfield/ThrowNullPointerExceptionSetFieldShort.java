package testclasses.exceptions.nullpointer.setfield;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassShort;

public class ThrowNullPointerExceptionSetFieldShort
{
    public ThrowNullPointerExceptionSetFieldShort()
    {

    }

    @Obfuscation
    public short exec(SupportClassShort obj)
    {
        obj.a = 0;
        return 0;
    }
}
