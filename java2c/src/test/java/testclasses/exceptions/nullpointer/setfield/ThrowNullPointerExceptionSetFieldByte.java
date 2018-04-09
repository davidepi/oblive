package testclasses.exceptions.nullpointer.setfield;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassByte;

public class ThrowNullPointerExceptionSetFieldByte
{
    public ThrowNullPointerExceptionSetFieldByte()
    {

    }

    @Obfuscate
    public byte exec(SupportClassByte obj)
    {
        obj.a = 0;
        return 0;
    }
}
