package testclasses.exceptions;

import it.se.obfuscator.Obfuscate;

public class ThrowArithmeticExceptionLREM
{
    public ThrowArithmeticExceptionLREM()
    {

    }

    @Obfuscate
    public static long mod(long a)
    {
        return a%0L;
    }
}
