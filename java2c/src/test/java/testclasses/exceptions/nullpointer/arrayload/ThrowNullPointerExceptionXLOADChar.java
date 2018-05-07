package testclasses.exceptions.nullpointer.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassChar;

public class ThrowNullPointerExceptionXLOADChar
{
    public ThrowNullPointerExceptionXLOADChar()
    {

    }

    @Obfuscation
    public int exec(SupportClassChar obj)
    {
        return obj.b[1];
    }
}
