package testclasses.exceptions;

import it.se.obfuscator.Obfuscate;

public class ThrowArithmeticExceptionIREM
{
    public ThrowArithmeticExceptionIREM()
    {

    }

    @Obfuscate
    public static int mod(int a)
    {
        return a%0;
    }
}
