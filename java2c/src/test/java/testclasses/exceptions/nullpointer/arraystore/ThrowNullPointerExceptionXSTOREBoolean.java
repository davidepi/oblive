package testclasses.exceptions.nullpointer.arraystore;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassBoolean;

public class ThrowNullPointerExceptionXSTOREBoolean
{
    public ThrowNullPointerExceptionXSTOREBoolean()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec(SupportClassBoolean obj)
    {
        obj.b[1] = true;
        return obj.b[1] ? 1 : 0;
    }
}
