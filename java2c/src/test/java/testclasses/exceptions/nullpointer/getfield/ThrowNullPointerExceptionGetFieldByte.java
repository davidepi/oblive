package testclasses.exceptions.nullpointer.getfield;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassByte;

public class ThrowNullPointerExceptionGetFieldByte
{
    public ThrowNullPointerExceptionGetFieldByte()
    {

    }

    @Obfuscation
    public byte exec(SupportClassByte obj)
    {
        return obj.a;
    }
}
