package testclasses.exceptions.nullpointer.arraylength;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassInt;

public class ThrowNullPointerExceptionArrayLengthInt
{
    public ThrowNullPointerExceptionArrayLengthInt()
    {

    }

    @Obfuscate
    public int exec(SupportClassInt obj)
    {
        return obj.b.length;
    }
}
