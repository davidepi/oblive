package testclasses.exceptions;

import it.se.obfuscator.Obfuscate;

public class CatchArithmeticExceptionLREM
{
    public CatchArithmeticExceptionLREM()
    {

    }

    @Obfuscate
    public static long divide(long a)
    {
        long res = 0;
        try
        {
            res += a % 0;
            res+=1000;
        }
        catch(ArithmeticException e)
        {
            res++;
        }

        try
        {
            res += a % 0;
            res+=1000;
        }
        catch(RuntimeException e)
        {
            res++;
        }

        try
        {
            res += a % 0;
            res+=1000;
        }
        catch(Exception e)
        {
            res++;
        }

        try
        {
            res += a % 0;
            res+=1000;
        }
        catch(Throwable e)
        {
            res++;
        }

        return res;
    }
}