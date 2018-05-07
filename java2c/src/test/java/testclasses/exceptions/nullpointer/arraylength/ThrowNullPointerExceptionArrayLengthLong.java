package testclasses.exceptions.nullpointer.arraylength;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassLong;

public class ThrowNullPointerExceptionArrayLengthLong
{
    public ThrowNullPointerExceptionArrayLengthLong()
    {

    }

    @Obfuscation
    public int exec(SupportClassLong obj)
    {
        return obj.b.length;
    }
}
