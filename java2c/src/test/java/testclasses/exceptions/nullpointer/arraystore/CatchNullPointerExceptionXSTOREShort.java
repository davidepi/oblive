package testclasses.exceptions.nullpointer.arraystore;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassShort;

public class CatchNullPointerExceptionXSTOREShort
{

    public CatchNullPointerExceptionXSTOREShort()
    {

    }

    @Obfuscate
    public int exec(SupportClassShort obj)
    {
        int res = 0;
        try
        {
            obj.b[1] = 1;
        }
        catch (NullPointerException e)
        {
            res++;
        }

        try
        {
            obj.b[1] = 0;
        }
        catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            obj.b[1] = 1;
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
            obj.b[1] = 0;
        }
        catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
