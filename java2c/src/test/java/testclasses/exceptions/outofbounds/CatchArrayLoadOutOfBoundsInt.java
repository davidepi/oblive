package testclasses.exceptions.outofbounds;

import it.se.obfuscator.Obfuscate;

public class CatchArrayLoadOutOfBoundsInt
{
    private int array[];
    public CatchArrayLoadOutOfBoundsInt()
    {
        this.array = new int[2];
    }

    @Obfuscate
    public int exec()
    {
        int res=0;

        try
        {
            return this.array[2];
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            res++;
        }

        try
        {
            return this.array[2];
        }
        catch (IndexOutOfBoundsException e)
        {
            res++;
        }

        try
        {
            return this.array[2];
        }
        catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            return this.array[2];
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
            return this.array[2];
        }
        catch (Throwable e)
        {
            res++;
        }

        try
        {
            return this.array[2];
        }
        catch (NullPointerException e)
        {
            res++;
        }

        return res;
    }
}
