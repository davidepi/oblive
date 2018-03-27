package testclasses.exceptions;

import it.se.obfuscator.Obfuscate;

public class CatchArithmeticExceptionIREM
{
    public CatchArithmeticExceptionIREM()
    {

    }

    @Obfuscate
    public static int divide(int a)
    {
        int res = 0;
        try
        {
            res += a % 0;
        }
        catch(ArithmeticException e)
        {
            res++;
        }

        try
        {
            res += a % 0;
        }
        catch(RuntimeException e)
        {
            res++;
        }

        try
        {
            res += a % 0;
        }
        catch(Exception e)
        {
            res++;
        }

        try
        {
            res += a % 0;
        }
        catch(Throwable e)
        {
            res++;
        }

        return res;
    }
}
