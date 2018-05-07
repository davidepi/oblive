package testclasses.exceptions.nullpointer.arraystore;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassByte;

public class ThrowNullPointerExceptionXSTOREByte
{
    public ThrowNullPointerExceptionXSTOREByte()
    {

    }

    @Obfuscation
    public int exec(SupportClassByte obj)
    {
        obj.b[1] = 1;
        return obj.b[1];
    }
}
