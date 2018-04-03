package testclasses.exceptions.nullpointer.arraystore;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassFloat;

public class ThrowNullPointerExceptionXSTOREFloat
{
    public ThrowNullPointerExceptionXSTOREFloat()
    {

    }

    @Obfuscate
    public int exec(SupportClassFloat obj)
    {
        obj.b[1] = 1;
        return (int)obj.b[1];
    }
}
