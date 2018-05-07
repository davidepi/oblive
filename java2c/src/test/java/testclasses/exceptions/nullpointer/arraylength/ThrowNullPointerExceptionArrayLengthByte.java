package testclasses.exceptions.nullpointer.arraylength;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassByte;

public class ThrowNullPointerExceptionArrayLengthByte
{
    public ThrowNullPointerExceptionArrayLengthByte()
    {

    }

    @Obfuscation
    public int exec(SupportClassByte obj)
    {
        return obj.b.length;
    }
}
