package testclasses.exceptions.nullpointer.setfield;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassByte;

public class ThrowNullPointerExceptionSetFieldByte
{
    public ThrowNullPointerExceptionSetFieldByte()
    {

    }

    @Obfuscation
    public byte exec(SupportClassByte obj)
    {
        obj.a = 0;
        return 0;
    }
}
