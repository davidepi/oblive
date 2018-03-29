package testclasses.exceptions.nullpointer.getfield;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassLong;

public class CatchNullPointerExceptionGetFieldLong
{

    public CatchNullPointerExceptionGetFieldLong()
    {

    }

    @Obfuscate
    public int exec(SupportClassLong obj)
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
