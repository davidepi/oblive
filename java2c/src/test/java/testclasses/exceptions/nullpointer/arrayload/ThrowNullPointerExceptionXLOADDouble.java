package testclasses.exceptions.nullpointer.arrayload;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassDouble;

public class ThrowNullPointerExceptionXLOADDouble
{
    public ThrowNullPointerExceptionXLOADDouble()
    {

    }

    @Obfuscate
    public int exec(SupportClassDouble obj)
    {
        return (int)obj.b[1];
    }
}
