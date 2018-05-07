package testclasses.exceptions.nullpointer.setfield;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassObject;

public class ThrowNullPointerExceptionSetFieldObject
{
    public ThrowNullPointerExceptionSetFieldObject()
    {

    }

    @Obfuscation
    public Object exec(SupportClassObject obj)
    {
        obj.a = "a";
        return obj;
    }
}
