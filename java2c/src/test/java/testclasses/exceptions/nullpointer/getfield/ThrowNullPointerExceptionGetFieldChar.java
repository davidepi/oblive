package testclasses.exceptions.nullpointer.getfield;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassChar;

public class ThrowNullPointerExceptionGetFieldChar
{
    public ThrowNullPointerExceptionGetFieldChar()
    {

    }

    @Obfuscate
    public char exec(SupportClassChar obj)
    {
        return obj.a;
    }
}
