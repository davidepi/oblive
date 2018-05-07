package testclasses.exceptions.nullpointer.getfield;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassLong;

public class ThrowNullPointerExceptionGetFieldLong
{
    public ThrowNullPointerExceptionGetFieldLong()
    {

    }

    @Obfuscation
    public long exec(SupportClassLong obj)
    {
        return obj.a;
    }
}
