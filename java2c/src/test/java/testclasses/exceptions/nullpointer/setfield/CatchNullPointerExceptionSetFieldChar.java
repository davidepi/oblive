package testclasses.exceptions.nullpointer.setfield;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassChar;

public class CatchNullPointerExceptionSetFieldChar
{

    public CatchNullPointerExceptionSetFieldChar()
    {

    }

    @Obfuscation
    public int exec(SupportClassChar obj)
    {
        int res = 0;
        try
        {
            obj.a=0;
            res+=1000;
        }
        catch (NullPointerException e)
        {
            res++;
        }

        try
        {
            obj.a=0;
            res+=1000;
        }
        catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            obj.a=0;
            res+=1000;
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
            obj.a=0;
            res+=1000;
        }
        catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
