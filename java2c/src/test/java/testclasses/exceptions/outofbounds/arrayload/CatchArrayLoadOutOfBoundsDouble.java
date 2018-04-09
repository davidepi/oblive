package testclasses.exceptions.outofbounds.arrayload;

import it.se.obfuscator.Obfuscate;

public class CatchArrayLoadOutOfBoundsDouble
{
    private double array[];
    public CatchArrayLoadOutOfBoundsDouble()
    {
        this.array = new double[2];
    }

    @Obfuscate
    public double exec()
    {
        int res=0;

        try
        {
          res+=(int)this.array[2];
          res+=1000;
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            res++;
        }

        try
        {
          res+=(int)this.array[2];
          res+=1000;
        }
        catch (IndexOutOfBoundsException e)
        {
            res++;
        }

        try
        {
          res+=(int)this.array[2];
          res+=1000;
        }
        catch (RuntimeException e)
        {
            res++;
        }

        try
        {
          res+=(int)this.array[2];
          res+=1000;
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
          res+=(int)this.array[2];
          res+=1000;
        }
        catch (Throwable e)
        {
            res++;
        }

        return (double)res;
    }
}
