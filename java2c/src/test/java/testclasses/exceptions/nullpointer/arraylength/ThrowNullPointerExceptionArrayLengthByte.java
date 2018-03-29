package testclasses.exceptions.nullpointer.arraylength;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassByte;

public class ThrowNullPointerExceptionArrayLengthByte
{
    public ThrowNullPointerExceptionArrayLengthByte()
    {

    }

    @Obfuscate
    public int exec(SupportClassByte obj)
    {
        return obj.b.length;
    }
}
