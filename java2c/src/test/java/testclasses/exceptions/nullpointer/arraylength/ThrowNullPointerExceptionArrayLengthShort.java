package testclasses.exceptions.nullpointer.arraylength;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassShort;

public class ThrowNullPointerExceptionArrayLengthShort
{
    public ThrowNullPointerExceptionArrayLengthShort()
    {

    }

    @Obfuscate
    public int exec(SupportClassShort obj)
    {
        return obj.b.length;
    }
}
