package testclasses.exceptions.nullpointer.setfield;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassInt;

public class ThrowNullPointerExceptionSetFieldInt
{
    public ThrowNullPointerExceptionSetFieldInt()
    {

    }

    @Obfuscation
    public int exec(SupportClassInt obj)
    {
        obj.a = 0;
        return 0;
    }
}
