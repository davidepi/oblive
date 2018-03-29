package testclasses.exceptions.nullpointer.arrayload;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassObject;

public class CatchNullPointerExceptionXLOADObject
{

    public CatchNullPointerExceptionXLOADObject()
    {

    }

    @Obfuscate
    public int exec(SupportClassObject obj)
    {
        int res = 0;
        try
        {
            return obj.b[1].length();
        }
        catch (NullPointerException e)
        {
            res++;
        }

        try
        {
            return obj.b[1].length();
        }
        catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            return obj.b[1].length();
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
            return obj.b[1].length();
        }
        catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
