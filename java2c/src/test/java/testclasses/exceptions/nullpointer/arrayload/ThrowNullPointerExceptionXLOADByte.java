package testclasses.exceptions.nullpointer.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassByte;

public class ThrowNullPointerExceptionXLOADByte
{
    public ThrowNullPointerExceptionXLOADByte()
    {

    }

    @Obfuscation
    public int exec(SupportClassByte obj)
    {
        return obj.b[1];
    }
}
