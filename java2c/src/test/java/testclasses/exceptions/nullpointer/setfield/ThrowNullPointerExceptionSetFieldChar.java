package testclasses.exceptions.nullpointer.setfield;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassChar;

public class ThrowNullPointerExceptionSetFieldChar
{
    public ThrowNullPointerExceptionSetFieldChar()
    {

    }

    @Obfuscate
    public char exec(SupportClassChar obj)
    {
        obj.a = 0;
        return 0;
    }
}
