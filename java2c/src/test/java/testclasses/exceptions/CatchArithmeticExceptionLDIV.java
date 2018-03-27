package testclasses.exceptions;

import it.se.obfuscator.Obfuscate;

public class CatchArithmeticExceptionLDIV
{
    public CatchArithmeticExceptionLDIV()
    {

    }

    @Obfuscate
    public static long divide(long a)
    {
        long res = 0;
        try
        {
            res += a / 0;
        }
        catch(ArithmeticException e)
        {
            res++;
        }

        try
        {
            res += a/0;
        }
        catch(RuntimeException e)
        {
            res++;
        }

        try
        {
            res += a/0;
        }
        catch(Exception e)
        {
            res++;
        }

        try
        {
            res += a/0;
        }
        catch(Throwable e)
        {
            res++;
        }

        return res;
    }
}
