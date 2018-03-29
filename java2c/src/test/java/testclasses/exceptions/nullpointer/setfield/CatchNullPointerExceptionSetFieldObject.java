package testclasses.exceptions.nullpointer.setfield;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassObject;

public class CatchNullPointerExceptionSetFieldObject
{

    public CatchNullPointerExceptionSetFieldObject()
    {

    }

    @Obfuscate
    public int exec(SupportClassObject obj)
    {
        int res = 0;
        try
        {
            obj.a="a";
        }
        catch (NullPointerException e)
        {
            res++;
        }

        try
        {
            obj.a="b";
        }
        catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            obj.a="c";
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
            obj.a="d";
        }
        catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
