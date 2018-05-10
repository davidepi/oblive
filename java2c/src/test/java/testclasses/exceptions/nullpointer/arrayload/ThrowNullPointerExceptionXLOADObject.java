package testclasses.exceptions.nullpointer.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassObject;

public class ThrowNullPointerExceptionXLOADObject
{
    public ThrowNullPointerExceptionXLOADObject()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec(SupportClassObject obj)
    {
        return obj.b[1].length();
    }
}
