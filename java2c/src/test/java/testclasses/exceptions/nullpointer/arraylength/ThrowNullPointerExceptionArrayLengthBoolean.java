package testclasses.exceptions.nullpointer.arraylength;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassBoolean;

public class ThrowNullPointerExceptionArrayLengthBoolean
{
    public ThrowNullPointerExceptionArrayLengthBoolean()
    {

    }

    @Obfuscation
    public int exec(SupportClassBoolean obj)
    {
        return obj.b.length;
    }
}
