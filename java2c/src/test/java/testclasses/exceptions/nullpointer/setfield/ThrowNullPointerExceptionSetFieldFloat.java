package testclasses.exceptions.nullpointer.setfield;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassFloat;

public class ThrowNullPointerExceptionSetFieldFloat
{
    public ThrowNullPointerExceptionSetFieldFloat()
    {

    }

    @Obfuscation
    public float exec(SupportClassFloat obj)
    {
        obj.a = 0;
        return 0;
    }
}
