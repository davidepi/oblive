package testclasses.exceptions.nullpointer.arraystore;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassBoolean;

public class ThrowNullPointerExceptionXSTOREBoolean
{
    public ThrowNullPointerExceptionXSTOREBoolean()
    {

    }

    @Obfuscate
    public int exec(SupportClassBoolean obj)
    {
        obj.b[1] = true;
        return obj.b[1]?1:0;
    }
}
