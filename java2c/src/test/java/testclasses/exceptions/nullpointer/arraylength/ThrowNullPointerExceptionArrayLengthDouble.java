package testclasses.exceptions.nullpointer.arraylength;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassDouble;

public class ThrowNullPointerExceptionArrayLengthDouble
{
    public ThrowNullPointerExceptionArrayLengthDouble()
    {

    }

    @Obfuscate
    public int exec(SupportClassDouble obj)
    {
        return obj.b.length;
    }
}
