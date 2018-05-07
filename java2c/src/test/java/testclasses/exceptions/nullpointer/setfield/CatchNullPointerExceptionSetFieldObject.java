package testclasses.exceptions.nullpointer.setfield;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassObject;

public class CatchNullPointerExceptionSetFieldObject
{

    public CatchNullPointerExceptionSetFieldObject()
    {

    }

    @Obfuscation
    public int exec(SupportClassObject obj)
    {
        int res = 0;
        try
        {
            obj.a="a";
            res+=1000;
        }
        catch (NullPointerException e)
        {
            res++;
        }

        try
        {
            obj.a="b";
            res+=1000;
        }
        catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            obj.a="c";
            res+=1000;
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
            obj.a="d";
            res+=1000;
        }
        catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
