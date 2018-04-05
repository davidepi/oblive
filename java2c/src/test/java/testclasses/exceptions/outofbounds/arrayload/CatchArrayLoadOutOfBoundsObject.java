package testclasses.exceptions.outofbounds.arrayload;

import it.se.obfuscator.Obfuscate;

public class CatchArrayLoadOutOfBoundsObject
{
    private String array[];
    public CatchArrayLoadOutOfBoundsObject()
    {
        this.array = new String[2];
    }

    @Obfuscate
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
