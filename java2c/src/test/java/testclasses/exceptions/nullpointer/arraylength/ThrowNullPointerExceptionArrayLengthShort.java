package testclasses.exceptions.nullpointer.arraylength;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassShort;

public class ThrowNullPointerExceptionArrayLengthShort
{
    public ThrowNullPointerExceptionArrayLengthShort()
    {

    }

    @Obfuscation
    public int exec(SupportClassShort obj)
    {
        return obj.b.length;
    }
}
