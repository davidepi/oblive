package testclasses.exceptions;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class CatchArithmeticExceptionIREM
{
    public CatchArithmeticExceptionIREM()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public static int divide(int a)
    {
        int res = 0;
        try
        {
            res += a % 0;
            res += 1000;
        } catch (ArithmeticException e)
        {
            res++;
        }

        try
        {
            res += a % 0;
            res += 1000;
        } catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            res += a % 0;
            res += 1000;
        } catch (Exception e)
        {
            res++;
        }

        try
        {
            res += a % 0;
            res += 1000;
        } catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
