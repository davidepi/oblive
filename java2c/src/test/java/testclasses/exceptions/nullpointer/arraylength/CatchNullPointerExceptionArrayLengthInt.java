package testclasses.exceptions.nullpointer.arraylength;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassInt;

public class CatchNullPointerExceptionArrayLengthInt
{

    public CatchNullPointerExceptionArrayLengthInt()
    {

    }

    @Obfuscate
    public int exec(SupportClassInt obj)
    {
        int res = 0;
        try
        {
            return obj.b.length;
        }
        catch (NullPointerException e)
        {
            res++;
        }

        try
        {
            return obj.b.length;
        }
        catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            return obj.b.length;
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
            return obj.b.length;
        }
        catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
