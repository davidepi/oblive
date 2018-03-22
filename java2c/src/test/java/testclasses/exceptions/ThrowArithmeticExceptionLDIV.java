package testclasses.exceptions;

import it.se.obfuscator.Obfuscate;

public class ThrowArithmeticExceptionLDIV
{
    public ThrowArithmeticExceptionLDIV()
    {

    }

    @Obfuscate
    public static long divide(long a)
    {
        return a/0L;
    }
}
