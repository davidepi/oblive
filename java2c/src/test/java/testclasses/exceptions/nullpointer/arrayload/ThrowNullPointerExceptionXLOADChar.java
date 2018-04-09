package testclasses.exceptions.nullpointer.arrayload;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassChar;

public class ThrowNullPointerExceptionXLOADChar
{
    public ThrowNullPointerExceptionXLOADChar()
    {

    }

    @Obfuscate
    public int exec(SupportClassChar obj)
    {
        return obj.b[1];
    }
}
