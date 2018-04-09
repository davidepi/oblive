package testclasses.exceptions.nullpointer.arraystore;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassByte;

public class ThrowNullPointerExceptionXSTOREByte
{
    public ThrowNullPointerExceptionXSTOREByte()
    {

    }

    @Obfuscate
    public int exec(SupportClassByte obj)
    {
        obj.b[1] = 1;
        return obj.b[1];
    }
}
