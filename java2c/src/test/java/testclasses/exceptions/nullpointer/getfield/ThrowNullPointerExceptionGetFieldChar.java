package testclasses.exceptions.nullpointer.getfield;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassChar;

public class ThrowNullPointerExceptionGetFieldChar
{
    public ThrowNullPointerExceptionGetFieldChar()
    {

    }

    @Obfuscation
    public char exec(SupportClassChar obj)
    {
        return obj.a;
    }
}
