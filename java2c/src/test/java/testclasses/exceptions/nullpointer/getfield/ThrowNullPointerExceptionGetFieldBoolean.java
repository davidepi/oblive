package testclasses.exceptions.nullpointer.getfield;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassBoolean;

public class ThrowNullPointerExceptionGetFieldBoolean
{
    public ThrowNullPointerExceptionGetFieldBoolean()
    {

    }

    @Obfuscation
    public boolean exec(SupportClassBoolean obj)
    {
        return obj.a;
    }
}
