package testclasses.exceptions.nullpointer.arraylength;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassChar;

public class ThrowNullPointerExceptionArrayLengthChar
{
    public ThrowNullPointerExceptionArrayLengthChar()
    {

    }

    @Obfuscate
    public int exec(SupportClassChar obj)
    {
        return obj.b.length;
    }
}
