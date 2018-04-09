package testclasses.exceptions.nullpointer.arrayload;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassObject;

public class ThrowNullPointerExceptionXLOADObject
{
    public ThrowNullPointerExceptionXLOADObject()
    {

    }

    @Obfuscate
    public int exec(SupportClassObject obj)
    {
        return obj.b[1].length();
    }
}
