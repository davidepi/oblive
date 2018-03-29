package testclasses.exceptions.nullpointer.getfield;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassDouble;

public class CatchNullPointerExceptionGetFieldDouble
{

    public CatchNullPointerExceptionGetFieldDouble()
    {

    }

    @Obfuscate
    public int exec(SupportClassDouble obj)
    {
        int res = 0;
        try
        {
            return (int)obj.a;
        }
        catch (NullPointerException e)
        {
            res++;
        }

        try
        {
            return (int)obj.a;
        }
        catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            return (int)obj.a;
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
            return (int)obj.a;
        }
        catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
