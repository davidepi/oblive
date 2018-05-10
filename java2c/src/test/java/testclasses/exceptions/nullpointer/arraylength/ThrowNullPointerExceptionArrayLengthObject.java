package testclasses.exceptions.nullpointer.arraylength;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassObject;

public class ThrowNullPointerExceptionArrayLengthObject
{
    public ThrowNullPointerExceptionArrayLengthObject()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec(SupportClassObject obj)
    {
        return obj.b.length;
    }
}
