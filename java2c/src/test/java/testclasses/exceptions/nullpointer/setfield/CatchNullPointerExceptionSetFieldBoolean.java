package testclasses.exceptions.nullpointer.setfield;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassBoolean;

public class CatchNullPointerExceptionSetFieldBoolean
{

    public CatchNullPointerExceptionSetFieldBoolean()
    {

    }

    @Obfuscate
    public int exec(SupportClassBoolean obj)
    {
        int res = 0;
        try
        {
            obj.a=true;
        }
        catch (NullPointerException e)
        {
            res++;
        }

        try
        {
            obj.a=true;
        }
        catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            obj.a=true;
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
            obj.a=true;
        }
        catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
