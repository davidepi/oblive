package testclasses.exceptions.nullpointer.setfield;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassLong;

public class ThrowNullPointerExceptionSetFieldLong
{
    public ThrowNullPointerExceptionSetFieldLong()
    {

    }

    @Obfuscation
    public long exec(SupportClassLong obj)
    {
        obj.a = 0;
        return 0;
    }
}
