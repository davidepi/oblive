package testclasses.exceptions.nullpointer.arraystore;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassShort;

public class ThrowNullPointerExceptionXSTOREShort
{
    public ThrowNullPointerExceptionXSTOREShort()
    {

    }

    @Obfuscation
    public int exec(SupportClassShort obj)
    {
        obj.b[1] = 1;
        return obj.b[1];
    }
}
