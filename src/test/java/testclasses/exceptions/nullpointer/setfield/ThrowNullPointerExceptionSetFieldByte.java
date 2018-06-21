package testclasses.exceptions.nullpointer.setfield;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassByte;

public class ThrowNullPointerExceptionSetFieldByte
{
    public ThrowNullPointerExceptionSetFieldByte()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public byte exec(SupportClassByte obj)
    {
        obj.a = 0;
        return 0;
    }
}
