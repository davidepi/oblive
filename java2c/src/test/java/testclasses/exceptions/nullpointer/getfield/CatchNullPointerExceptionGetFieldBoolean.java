package testclasses.exceptions.nullpointer.getfield;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassBoolean;

public class CatchNullPointerExceptionGetFieldBoolean
{

    public CatchNullPointerExceptionGetFieldBoolean()
    {

    }

    @Obfuscate
    public int exec(SupportClassBoolean obj)
    {
        int res = 0;
        try
        {
            return obj.a?1:0;
        }
        catch (NullPointerException e)
        {
            res++;
        }

        try
        {
            return obj.a?1:0;
        }
        catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            return obj.a?1:0;
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
            return obj.a?1:0;
        }
        catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
