package testclasses.exceptions.outofbounds.arraystore;

import it.se.obfuscator.Obfuscate;

public class CatchArrayStoreOutOfBoundsInt
{
    private int array[];
    public CatchArrayStoreOutOfBoundsInt()
    {
        this.array = new int[2];
    }

    @Obfuscate
    public int exec()
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

        return res;
    }
}
