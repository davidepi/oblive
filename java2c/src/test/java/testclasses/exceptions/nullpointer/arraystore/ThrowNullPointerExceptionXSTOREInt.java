package testclasses.exceptions.nullpointer.arraystore;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassInt;

public class ThrowNullPointerExceptionXSTOREInt
{
    public ThrowNullPointerExceptionXSTOREInt()
    {

    }

    @Obfuscation
    public int exec(SupportClassInt obj)
    {
        obj.b[1] = 1;
        return obj.b[1];
    }
}
