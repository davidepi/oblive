package testclasses.exceptions.nullpointer.arrayload;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassByte;

public class CatchNullPointerExceptionXLOADByte
{

    public CatchNullPointerExceptionXLOADByte()
    {

    }

    @Obfuscate
    public int exec(SupportClassByte obj)
    {

        int res = 0;
        try
        {
            return obj.b[1];
        }
        catch (NullPointerException e)
        {
            res++;
        }

        try
        {
            return obj.b[1];
        }
        catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            return obj.b[1];
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
            return obj.b[1];
        }
        catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
