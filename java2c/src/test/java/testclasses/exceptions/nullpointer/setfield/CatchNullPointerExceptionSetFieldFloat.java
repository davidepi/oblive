package testclasses.exceptions.nullpointer.setfield;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassFloat;

public class CatchNullPointerExceptionSetFieldFloat
{

    public CatchNullPointerExceptionSetFieldFloat()
    {

    }

    @Obfuscate
    public int exec(SupportClassFloat obj)
    {
        int res = 0;
        try
        {
            obj.a=0;
        }
        catch (NullPointerException e)
        {
            res++;
        }

        try
        {
            obj.a=0;
        }
        catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            obj.a=0;
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
            obj.a=0;
        }
        catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
