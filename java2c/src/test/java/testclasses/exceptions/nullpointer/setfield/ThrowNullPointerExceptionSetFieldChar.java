package testclasses.exceptions.nullpointer.setfield;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassChar;

public class ThrowNullPointerExceptionSetFieldChar
{
    public ThrowNullPointerExceptionSetFieldChar()
    {

    }

    @Obfuscation
    public char exec(SupportClassChar obj)
    {
        obj.a = 0;
        return 0;
    }
}
