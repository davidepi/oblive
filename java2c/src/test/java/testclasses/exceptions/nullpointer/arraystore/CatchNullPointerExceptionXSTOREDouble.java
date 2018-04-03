package testclasses.exceptions.nullpointer.arraystore;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassDouble;

public class CatchNullPointerExceptionXSTOREDouble
{

    public CatchNullPointerExceptionXSTOREDouble()
    {

    }

    @Obfuscate
    public int exec(SupportClassDouble obj)
    {
        int res = 0;
        try
        {
            obj.b[1] = (double)1;
        }
        catch (NullPointerException e)
        {
            res++;
        }

        try
        {
            obj.b[1] = (double)0;
        }
        catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            obj.b[1] = (double)1;
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
            obj.b[1] = (double)0;
        }
        catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
