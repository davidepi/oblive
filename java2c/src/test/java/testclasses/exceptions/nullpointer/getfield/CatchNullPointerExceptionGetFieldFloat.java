package testclasses.exceptions.nullpointer.getfield;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassFloat;

public class CatchNullPointerExceptionGetFieldFloat
{

    public CatchNullPointerExceptionGetFieldFloat()
    {

    }

    @Obfuscate
    public int exec(SupportClassFloat obj)
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
