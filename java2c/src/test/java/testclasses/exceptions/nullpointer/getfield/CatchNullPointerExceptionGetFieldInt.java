package testclasses.exceptions.nullpointer.getfield;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassInt;

public class CatchNullPointerExceptionGetFieldInt
{

    public CatchNullPointerExceptionGetFieldInt()
    {

    }

    @Obfuscate
    public int exec(SupportClassInt obj)
    {
        int res = 0;
        try
        {
            return obj.a;
        }
        catch (NullPointerException e)
        {
            res++;
        }

        try
        {
            return obj.a;
        }
        catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            return obj.a;
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
            return obj.a;
        }
        catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
