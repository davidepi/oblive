package testclasses.exceptions.nullpointer.arraylength;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassObject;

public class ThrowNullPointerExceptionArrayLengthObject
{
    public ThrowNullPointerExceptionArrayLengthObject()
    {

    }

    @Obfuscation
    public int exec(SupportClassObject obj)
    {
        return obj.b.length;
    }
}
