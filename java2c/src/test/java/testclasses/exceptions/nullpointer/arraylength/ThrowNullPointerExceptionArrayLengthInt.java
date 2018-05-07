package testclasses.exceptions.nullpointer.arraylength;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassInt;

public class ThrowNullPointerExceptionArrayLengthInt
{
    public ThrowNullPointerExceptionArrayLengthInt()
    {

    }

    @Obfuscation
    public int exec(SupportClassInt obj)
    {
        return obj.b.length;
    }
}
