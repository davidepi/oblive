package testclasses.exceptions.nullpointer.arraylength;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassChar;

public class ThrowNullPointerExceptionArrayLengthChar
{
    public ThrowNullPointerExceptionArrayLengthChar()
    {

    }

    @Obfuscation
    public int exec(SupportClassChar obj)
    {
        return obj.b.length;
    }
}
