package testclasses.exceptions.nullpointer.setfield;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassObject;

public class ThrowNullPointerExceptionSetFieldObject
{
    public ThrowNullPointerExceptionSetFieldObject()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public Object exec(SupportClassObject obj)
    {
        obj.a = "a";
        return obj;
    }
}
