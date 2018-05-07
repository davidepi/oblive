package testclasses.exceptions;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowArithmeticExceptionLREM
{
    public ThrowArithmeticExceptionLREM()
    {

    }

    @Obfuscation
    public static long mod(long a)
    {
        return a%0L;
    }
}
