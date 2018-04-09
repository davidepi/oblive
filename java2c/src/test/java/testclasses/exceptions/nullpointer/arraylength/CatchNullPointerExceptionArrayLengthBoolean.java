package testclasses.exceptions.nullpointer.arraylength;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassBoolean;

public class CatchNullPointerExceptionArrayLengthBoolean
{

    public CatchNullPointerExceptionArrayLengthBoolean()
    {

    }

    @Obfuscate
    public int exec(SupportClassBoolean obj)
    {
        int res = 0;
        try
        {
            res = obj.b.length;
            res+=1000;
        }
        catch (NullPointerException e)
        {
            res++;
        }

        try
        {
            res = obj.b.length;
            res+=1000;
        }
        catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            res = obj.b.length;
            res+=1000;
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
            res = obj.b.length;
            res+=1000;
        }
        catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
