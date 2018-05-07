package testclasses.exceptions.nullpointer.arraylength;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassObject;

public class CatchNullPointerExceptionArrayLengthObject
{

    public CatchNullPointerExceptionArrayLengthObject()
    {

    }

    @Obfuscation
    public int exec(SupportClassObject obj)
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
