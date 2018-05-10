package testclasses.exceptions.nullpointer.arraystore;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassInt;

public class ThrowNullPointerExceptionXSTOREInt
{
    public ThrowNullPointerExceptionXSTOREInt()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec(SupportClassInt obj)
    {
        obj.b[1] = 1;
        return obj.b[1];
    }
}
