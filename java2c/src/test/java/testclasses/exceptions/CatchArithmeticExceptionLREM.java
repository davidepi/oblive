package testclasses.exceptions;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class CatchArithmeticExceptionLREM
{
    public CatchArithmeticExceptionLREM()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public static long divide(long a)
    {
        long res = 0;
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
