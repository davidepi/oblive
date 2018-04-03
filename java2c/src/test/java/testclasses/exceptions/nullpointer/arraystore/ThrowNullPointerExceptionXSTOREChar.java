package testclasses.exceptions.nullpointer.arraystore;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassChar;

public class ThrowNullPointerExceptionXSTOREChar
{
    public ThrowNullPointerExceptionXSTOREChar()
    {

    }

    @Obfuscate
    public int exec(SupportClassChar obj)
    {
        obj.b[1] = 1;
        return obj.b[1];
    }
}
