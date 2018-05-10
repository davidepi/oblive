package testclasses.exceptions.nullpointer.setfield;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassChar;

public class ThrowNullPointerExceptionSetFieldChar
{
    public ThrowNullPointerExceptionSetFieldChar()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public char exec(SupportClassChar obj)
    {
        obj.a = 0;
        return 0;
    }
}
