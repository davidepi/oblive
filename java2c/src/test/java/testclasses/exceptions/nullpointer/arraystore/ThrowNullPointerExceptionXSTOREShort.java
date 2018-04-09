package testclasses.exceptions.nullpointer.arraystore;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassShort;

public class ThrowNullPointerExceptionXSTOREShort
{
    public ThrowNullPointerExceptionXSTOREShort()
    {

    }

    @Obfuscate
    public int exec(SupportClassShort obj)
    {
        obj.b[1] = 1;
        return obj.b[1];
    }
}
