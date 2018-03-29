package testclasses.exceptions.nullpointer.arraylength;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassObject;

public class ThrowNullPointerExceptionArrayLengthObject
{
    public ThrowNullPointerExceptionArrayLengthObject()
    {

    }

    @Obfuscate
    public int exec(SupportClassObject obj)
    {
        return obj.b.length;
    }
}
