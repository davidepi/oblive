package testclasses.exceptions.nullpointer.getfield;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassByte;

public class ThrowNullPointerExceptionGetFieldByte
{
    public ThrowNullPointerExceptionGetFieldByte()
    {

    }

    @Obfuscate
    public byte exec(SupportClassByte obj)
    {
        return obj.a;
    }
}
