package testclasses.exceptions.nullpointer.arraystore;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassLong;

public class ThrowNullPointerExceptionXSTORELong
{
    public ThrowNullPointerExceptionXSTORELong()
    {

    }

    @Obfuscate
    public int exec(SupportClassLong obj)
    {
        obj.b[1] = 1;
        return (int)obj.b[1];
    }
}
