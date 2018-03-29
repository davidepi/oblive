package testclasses.exceptions.nullpointer.getfield;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassObject;

public class CatchNullPointerExceptionGetFieldObject
{

    public CatchNullPointerExceptionGetFieldObject()
    {

    }

    @Obfuscate
    public int exec(SupportClassObject obj)
    {
        int res = 0;
        try
        {
            return obj.a.length();
        }
        catch (NullPointerException e)
        {
            res++;
        }

        try
        {
            return obj.a.length();
        }
        catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            return obj.a.length();
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
            return obj.a.length();
        }
        catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
