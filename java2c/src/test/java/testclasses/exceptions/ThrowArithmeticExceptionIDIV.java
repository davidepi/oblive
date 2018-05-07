package testclasses.exceptions;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowArithmeticExceptionIDIV
{
    public ThrowArithmeticExceptionIDIV()
    {

    }

    @Obfuscation
    public static int divide(int a)
    {
        return a/0;
    }
}
