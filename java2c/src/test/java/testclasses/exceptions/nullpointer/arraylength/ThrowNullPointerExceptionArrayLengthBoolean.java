package testclasses.exceptions.nullpointer.arraylength;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassBoolean;

public class ThrowNullPointerExceptionArrayLengthBoolean
{
    public ThrowNullPointerExceptionArrayLengthBoolean()
    {

    }

    @Obfuscate
    public int exec(SupportClassBoolean obj)
    {
        return obj.b.length;
    }
}
