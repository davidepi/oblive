package testclasses.exceptions.nullpointer.getfield;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassFloat;

public class ThrowNullPointerExceptionGetFieldFloat
{
    public ThrowNullPointerExceptionGetFieldFloat()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public float exec(SupportClassFloat obj)
    {
        return obj.a;
    }
}
