package testclasses.exceptions;

import it.se.obfuscator.Obfuscate;

public class ThrowArithmeticExceptionIDIV
{
    public ThrowArithmeticExceptionIDIV()
    {

    }

    @Obfuscate
    public static int divide(int a)
    {
        return a/0;
    }
}
