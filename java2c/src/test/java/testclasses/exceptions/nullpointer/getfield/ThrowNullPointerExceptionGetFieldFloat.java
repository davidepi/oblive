package testclasses.exceptions.nullpointer.getfield;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassFloat;

public class ThrowNullPointerExceptionGetFieldFloat
{
    public ThrowNullPointerExceptionGetFieldFloat()
    {

    }

    @Obfuscation
    public float exec(SupportClassFloat obj)
    {
        return obj.a;
    }
}
