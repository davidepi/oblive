package testclasses.exceptions.nullpointer.arrayload;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassLong;

public class CatchNullPointerExceptionXLOADLong
{

    public CatchNullPointerExceptionXLOADLong()
    {

    }

    @Obfuscate
    public int exec(SupportClassLong obj)
    {
        int res = 0;
        try
        {
            return (int)obj.b[1];
        }
        catch (NullPointerException e)
        {
            res++;
        }

        try
        {
            return (int)obj.b[1];
        }
        catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            return (int)obj.b[1];
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
            return (int)obj.b[1];
        }
        catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
