package testclasses.exceptions.nullpointer.getfield;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassLong;

public class ThrowNullPointerExceptionGetFieldLong
{
    public ThrowNullPointerExceptionGetFieldLong()
    {

    }

    @Obfuscate
    public long exec(SupportClassLong obj)
    {
        return obj.a;
    }
}
