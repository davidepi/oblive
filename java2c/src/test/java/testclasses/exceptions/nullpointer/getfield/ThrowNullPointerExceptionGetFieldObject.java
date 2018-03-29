package testclasses.exceptions.nullpointer.getfield;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassObject;

public class ThrowNullPointerExceptionGetFieldObject
{
    public ThrowNullPointerExceptionGetFieldObject()
    {

    }

    @Obfuscate
    public Object exec(SupportClassObject obj)
    {
        return obj.a;
    }
}
