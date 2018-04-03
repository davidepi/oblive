package testclasses.exceptions.nullpointer.arraystore;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassBoolean;

public class CatchNullPointerExceptionXSTOREBoolean
{

    public CatchNullPointerExceptionXSTOREBoolean()
    {

    }

    @Obfuscate
    public int exec(SupportClassBoolean obj)
    {
        int res = 0;
        try
        {
           obj.b[1] = false;
        }
        catch (NullPointerException e)
        {
            res++;
        }

        try
        {
            obj.b[1] = true;
        }
        catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            obj.b[1] = false;
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
            obj.b[1] = true;
        }
        catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
