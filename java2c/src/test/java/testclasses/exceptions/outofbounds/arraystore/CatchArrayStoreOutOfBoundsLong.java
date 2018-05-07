package testclasses.exceptions.outofbounds.arraystore;

import eu.fbk.hardening.annotation.Obfuscation;

public class CatchArrayStoreOutOfBoundsLong
{
    private long array[];
    public CatchArrayStoreOutOfBoundsLong()
    {
        this.array = new long[2];
    }

    @Obfuscation
    public long exec()
    {
        int res=0;

        try
        {
            this.array[2] = 1;
            res+=1000;
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            res++;
        }

        try
        {
            this.array[2] = 0;
            res+=1000;
        }
        catch (IndexOutOfBoundsException e)
        {
            res++;
        }

        try
        {
            this.array[2] = 1;
            res+=1000;
        }
        catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            this.array[2] = 0;
            res+=1000;
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
          this.array[2] = 1;
          res+=1000;
        }
        catch (Throwable e)
        {
            res++;
        }

        return (long)res;
    }
}
