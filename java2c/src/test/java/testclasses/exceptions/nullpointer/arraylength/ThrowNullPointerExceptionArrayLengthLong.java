package testclasses.exceptions.nullpointer.arraylength;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassLong;

public class ThrowNullPointerExceptionArrayLengthLong
{
    public ThrowNullPointerExceptionArrayLengthLong()
    {

    }

    @Obfuscate
    public int exec(SupportClassLong obj)
    {
        return obj.b.length;
    }
}
