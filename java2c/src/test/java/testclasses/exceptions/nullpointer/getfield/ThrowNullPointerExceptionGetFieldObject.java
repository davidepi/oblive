package testclasses.exceptions.nullpointer.getfield;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassObject;

public class ThrowNullPointerExceptionGetFieldObject
{
    public ThrowNullPointerExceptionGetFieldObject()
    {

    }

    @Obfuscation
    public Object exec(SupportClassObject obj)
    {
        return obj.a;
    }
}
