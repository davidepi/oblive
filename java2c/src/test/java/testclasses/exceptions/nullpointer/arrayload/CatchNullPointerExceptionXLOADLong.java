package testclasses.exceptions.nullpointer.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassLong;

public class CatchNullPointerExceptionXLOADLong
{

    public CatchNullPointerExceptionXLOADLong()
    {

    }

    @Obfuscation
    public int exec(SupportClassLong obj)
    {
        int res = 0;
        try
        {
          res+=(int)obj.b[1];
          res+=1000;
        }
        catch (NullPointerException e)
        {
            res++;
        }

        try
        {
          res+=(int)obj.b[1];
          res+=1000;
        }
        catch (RuntimeException e)
        {
            res++;
        }

        try
        {
          res+=(int)obj.b[1];
          res+=1000;
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
          res+=(int)obj.b[1];
          res+=1000;
        }
        catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
