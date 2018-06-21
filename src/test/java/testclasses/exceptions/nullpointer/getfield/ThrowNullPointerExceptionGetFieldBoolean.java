package testclasses.exceptions.nullpointer.getfield;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassBoolean;

public class ThrowNullPointerExceptionGetFieldBoolean
{
    public ThrowNullPointerExceptionGetFieldBoolean()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public boolean exec(SupportClassBoolean obj)
    {
        return obj.a;
    }
}
