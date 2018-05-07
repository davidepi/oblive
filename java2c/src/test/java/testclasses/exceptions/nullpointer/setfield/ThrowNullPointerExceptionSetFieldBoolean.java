package testclasses.exceptions.nullpointer.setfield;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassBoolean;

public class ThrowNullPointerExceptionSetFieldBoolean
{
    public ThrowNullPointerExceptionSetFieldBoolean()
    {

    }

    @Obfuscation
    public boolean exec(SupportClassBoolean obj)
    {
        obj.a = false;
        return true;
    }
}
