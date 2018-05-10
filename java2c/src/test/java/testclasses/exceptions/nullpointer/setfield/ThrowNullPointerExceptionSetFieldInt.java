package testclasses.exceptions.nullpointer.setfield;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassInt;

public class ThrowNullPointerExceptionSetFieldInt
{
    public ThrowNullPointerExceptionSetFieldInt()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec(SupportClassInt obj)
    {
        obj.a = 0;
        return 0;
    }
}
