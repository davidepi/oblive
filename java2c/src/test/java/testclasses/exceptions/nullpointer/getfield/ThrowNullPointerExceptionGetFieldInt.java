package testclasses.exceptions.nullpointer.getfield;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassInt;

public class ThrowNullPointerExceptionGetFieldInt
{
    public ThrowNullPointerExceptionGetFieldInt()
    {

    }

    @Obfuscation
    public int exec(SupportClassInt obj)
    {
        return obj.a;
    }
}
