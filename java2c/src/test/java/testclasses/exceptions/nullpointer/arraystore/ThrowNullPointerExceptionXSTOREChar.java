package testclasses.exceptions.nullpointer.arraystore;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassChar;

public class ThrowNullPointerExceptionXSTOREChar
{
    public ThrowNullPointerExceptionXSTOREChar()
    {

    }

    @Obfuscation
    public int exec(SupportClassChar obj)
    {
        obj.b[1] = 1;
        return obj.b[1];
    }
}
