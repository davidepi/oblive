package testclasses.exceptions.nullpointer.arraystore;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassDouble;

public class ThrowNullPointerExceptionXSTOREDouble
{
    public ThrowNullPointerExceptionXSTOREDouble()
    {

    }

    @Obfuscate
    public int exec(SupportClassDouble obj)
    {
        obj.b[1] = 1;
        return (int)obj.b[1];
    }
}
