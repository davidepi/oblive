package testclasses.exceptions.nullpointer.setfield;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassObject;

public class ThrowNullPointerExceptionSetFieldObject
{
    public ThrowNullPointerExceptionSetFieldObject()
    {

    }

    @Obfuscate
    public Object exec(SupportClassObject obj)
    {
        obj.a = "a";
        return obj;
    }
}
