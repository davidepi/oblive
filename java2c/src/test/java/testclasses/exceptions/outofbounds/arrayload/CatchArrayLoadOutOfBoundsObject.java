package testclasses.exceptions.outofbounds.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;

public class CatchArrayLoadOutOfBoundsObject
{
    private String array[];
    public CatchArrayLoadOutOfBoundsObject()
    {
        this.array = new String[2];
    }

    @Obfuscation
    public String exec()
    {
        int res=0;

        try
        {
          res+=(int)this.array[2].length();
          res+=1000;
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            res++;
        }

        try
        {
          res+=(int)this.array[2].length();
          res+=1000;
        }
        catch (IndexOutOfBoundsException e)
        {
            res++;
        }

        try
        {
          res+=(int)this.array[2].length();
          res+=1000;
        }
        catch (RuntimeException e)
        {
            res++;
        }

        try
        {
          res+=(int)this.array[2].length();
          res+=1000;
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
          res+=(int)this.array[2].length();
          res+=1000;
        }
        catch (Throwable e)
        {
            res++;
        }

        return ((Integer)res).toString();
    }
}
