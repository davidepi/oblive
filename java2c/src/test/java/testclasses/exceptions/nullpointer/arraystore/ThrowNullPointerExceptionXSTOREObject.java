package testclasses.exceptions.nullpointer.arraystore;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassObject;

public class ThrowNullPointerExceptionXSTOREObject
{
    public ThrowNullPointerExceptionXSTOREObject()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec(SupportClassObject obj)
    {
        obj.b[1] = "str0";
        return obj.b[1].length();
    }
}
