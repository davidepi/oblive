package testclasses.exceptions.nullpointer.getfield;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassChar;

public class CatchNullPointerExceptionGetFieldChar
{

    public CatchNullPointerExceptionGetFieldChar()
    {

    }

    @Obfuscate
    public int exec(SupportClassChar obj)
    {
        int res = 0;
        try
        {
          res+=(int)obj.a;
          res+=1000;
        }
        catch (NullPointerException e)
        {
            res++;
        }

        try
        {
          res+=(int)obj.a;
          res+=1000;
        }
        catch (RuntimeException e)
        {
            res++;
        }

        try
        {
          res+=(int)obj.a;
          res+=1000;
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
          res+=(int)obj.a;
          res+=1000;
        }
        catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}