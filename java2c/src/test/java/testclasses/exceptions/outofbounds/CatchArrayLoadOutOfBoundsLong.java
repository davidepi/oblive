package testclasses.exceptions.outofbounds;

import it.se.obfuscator.Obfuscate;

public class CatchArrayLoadOutOfBoundsLong
{
    private long array[];
    public CatchArrayLoadOutOfBoundsLong()
    {
        this.array = new long[2];
    }

    @Obfuscate
    public long exec()
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

        return (long)res;
    }
}
