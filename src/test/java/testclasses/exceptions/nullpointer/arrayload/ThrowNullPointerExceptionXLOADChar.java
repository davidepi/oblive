package testclasses.exceptions.nullpointer.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassChar;

public class ThrowNullPointerExceptionXLOADChar
{
    public ThrowNullPointerExceptionXLOADChar()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec(SupportClassChar obj)
    {
        return obj.b[1];
    }
}
