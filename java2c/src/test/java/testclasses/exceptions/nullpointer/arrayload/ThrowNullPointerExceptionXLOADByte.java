package testclasses.exceptions.nullpointer.arrayload;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassByte;

public class ThrowNullPointerExceptionXLOADByte
{
    public ThrowNullPointerExceptionXLOADByte()
    {

    }

    @Obfuscate
    public int exec(SupportClassByte obj)
    {
        return obj.b[1];
    }
}
