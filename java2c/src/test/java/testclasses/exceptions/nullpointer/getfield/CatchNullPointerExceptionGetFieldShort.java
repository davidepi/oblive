package testclasses.exceptions.nullpointer.getfield;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassShort;

public class CatchNullPointerExceptionGetFieldShort
{

    public CatchNullPointerExceptionGetFieldShort()
    {

    }

    @Obfuscate
    public int exec(SupportClassShort obj)
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
