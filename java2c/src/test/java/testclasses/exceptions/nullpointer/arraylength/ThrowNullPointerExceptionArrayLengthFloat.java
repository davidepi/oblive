package testclasses.exceptions.nullpointer.arraylength;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassFloat;

public class ThrowNullPointerExceptionArrayLengthFloat
{
    public ThrowNullPointerExceptionArrayLengthFloat()
    {

    }

    @Obfuscation
    public int exec(SupportClassFloat obj)
    {
        return obj.b.length;
    }
}
