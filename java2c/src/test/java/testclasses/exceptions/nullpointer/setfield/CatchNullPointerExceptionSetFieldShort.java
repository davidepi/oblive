package testclasses.exceptions.nullpointer.setfield;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassShort;

public class CatchNullPointerExceptionSetFieldShort
{

    public CatchNullPointerExceptionSetFieldShort()
    {

    }

    @Obfuscate
    public int exec(SupportClassShort obj)
    {
        int res = 0;
        try
        {
            obj.a = 0;
        }
        catch (NullPointerException e)
        {
            res++;
        }

        try
        {
            obj.a = 0;
        }
        catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            obj.a = 0;
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
            obj.a = 0;
        }
        catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
