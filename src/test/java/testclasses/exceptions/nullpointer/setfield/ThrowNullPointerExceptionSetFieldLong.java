package testclasses.exceptions.nullpointer.setfield;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassLong;

public class ThrowNullPointerExceptionSetFieldLong
{
    public ThrowNullPointerExceptionSetFieldLong()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public long exec(SupportClassLong obj)
    {
        obj.a = 0;
        return 0;
    }
}
