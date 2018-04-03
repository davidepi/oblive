package testclasses.exceptions.nullpointer.arraystore;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassObject;

public class ThrowNullPointerExceptionXSTOREObject
{
    public ThrowNullPointerExceptionXSTOREObject()
    {

    }

    @Obfuscate
    public int exec(SupportClassObject obj)
    {
        obj.b[1] = "str0";
        return obj.b[1].length();
    }
}
