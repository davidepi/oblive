package testclasses.exceptions.nullpointer.setfield;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassDouble;

public class ThrowNullPointerExceptionSetFieldDouble
{
    public ThrowNullPointerExceptionSetFieldDouble()
    {

    }

    @Obfuscate
    public double exec(SupportClassDouble obj)
    {
        obj.a = 0;
        return 0;
    }
}
