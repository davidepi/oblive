package testclasses.exceptions.nullpointer.getfield;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassDouble;

public class ThrowNullPointerExceptionGetFieldDouble
{
    public ThrowNullPointerExceptionGetFieldDouble()
    {

    }

    @Obfuscate
    public double exec(SupportClassDouble obj)
    {
        return obj.a;
    }
}
