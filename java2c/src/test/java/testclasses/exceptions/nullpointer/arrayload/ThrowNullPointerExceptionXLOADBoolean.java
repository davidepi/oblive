package testclasses.exceptions.nullpointer.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassBoolean;

public class ThrowNullPointerExceptionXLOADBoolean
{
    public ThrowNullPointerExceptionXLOADBoolean()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec(SupportClassBoolean obj)
    {
        return obj.b[1] ? 1 : 0;
    }
}
