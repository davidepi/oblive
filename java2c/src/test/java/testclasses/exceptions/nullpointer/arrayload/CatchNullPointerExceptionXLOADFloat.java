package testclasses.exceptions.nullpointer.arrayload;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassFloat;

public class CatchNullPointerExceptionXLOADFloat
{

    public CatchNullPointerExceptionXLOADFloat()
    {

    }

    @Obfuscate
    public int exec(SupportClassFloat obj)
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
