package testclasses.exceptions;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowArithmeticExceptionLDIV
{
    public ThrowArithmeticExceptionLDIV()
    {

    }

    @Obfuscation
    public static long divide(long a)
    {
        return a/0L;
    }
}
