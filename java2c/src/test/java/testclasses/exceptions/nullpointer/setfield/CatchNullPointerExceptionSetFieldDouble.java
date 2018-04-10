package testclasses.exceptions.nullpointer.setfield;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassDouble;

public class CatchNullPointerExceptionSetFieldDouble
{

    public CatchNullPointerExceptionSetFieldDouble()
    {

    }

    @Obfuscate
    public int exec(SupportClassDouble obj)
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