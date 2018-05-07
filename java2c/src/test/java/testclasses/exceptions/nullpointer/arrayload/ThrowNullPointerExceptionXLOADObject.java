package testclasses.exceptions.nullpointer.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassObject;

public class ThrowNullPointerExceptionXLOADObject
{
    public ThrowNullPointerExceptionXLOADObject()
    {

    }

    @Obfuscation
    public int exec(SupportClassObject obj)
    {
        return obj.b[1].length();
    }
}
