package testclasses.exceptions;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowArithmeticExceptionIREM
{
    public ThrowArithmeticExceptionIREM()
    {

    }

    @Obfuscation
    public static int mod(int a)
    {
        return a%0;
    }
}
