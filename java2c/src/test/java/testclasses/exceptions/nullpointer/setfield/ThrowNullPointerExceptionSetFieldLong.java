package testclasses.exceptions.nullpointer.setfield;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassLong;

public class ThrowNullPointerExceptionSetFieldLong
{
    public ThrowNullPointerExceptionSetFieldLong()
    {

    }

    @Obfuscate
    public long exec(SupportClassLong obj)
    {
        obj.a = 0;
        return 0;
    }
}
