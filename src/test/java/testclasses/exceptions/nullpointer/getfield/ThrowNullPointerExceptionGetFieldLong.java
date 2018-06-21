package testclasses.exceptions.nullpointer.getfield;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassLong;

public class ThrowNullPointerExceptionGetFieldLong
{
    public ThrowNullPointerExceptionGetFieldLong()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public long exec(SupportClassLong obj)
    {
        return obj.a;
    }
}
