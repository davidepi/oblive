package testclasses.exceptions.nullpointer.arraystore;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassInt;

public class ThrowNullPointerExceptionXSTOREInt
{
    public ThrowNullPointerExceptionXSTOREInt()
    {

    }

    @Obfuscate
    public int exec(SupportClassInt obj)
    {
        obj.b[1] = 1;
        return obj.b[1];
    }
}
