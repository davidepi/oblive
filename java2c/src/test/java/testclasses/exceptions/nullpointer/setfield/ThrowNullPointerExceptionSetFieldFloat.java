package testclasses.exceptions.nullpointer.setfield;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassFloat;

public class ThrowNullPointerExceptionSetFieldFloat
{
    public ThrowNullPointerExceptionSetFieldFloat()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public float exec(SupportClassFloat obj)
    {
        obj.a = 0;
        return 0;
    }
}
