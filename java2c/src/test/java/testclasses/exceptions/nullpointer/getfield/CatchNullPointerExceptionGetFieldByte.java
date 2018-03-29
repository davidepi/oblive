package testclasses.exceptions.nullpointer.getfield;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassByte;

public class CatchNullPointerExceptionGetFieldByte
{

    public CatchNullPointerExceptionGetFieldByte()
    {

    }

    @Obfuscate
    public int exec(SupportClassByte obj)
    {
        int res = 0;
        try
        {
            return obj.a;
        }
        catch (NullPointerException e)
        {
            res++;
        }

        try
        {
            return obj.a;
        }
        catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            return obj.a;
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
            return obj.a;
        }
        catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
