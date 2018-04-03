package testclasses.exceptions.outofbounds.arraystore;

import it.se.obfuscator.Obfuscate;

public class CatchArrayStoreOutOfBoundsShort
{
    private short array[];
    public CatchArrayStoreOutOfBoundsShort()
    {
        this.array = new short[2];
    }

    @Obfuscate
    public int exec()
    {
        int res=0;

        try
        {
            this.array[2] = 1;
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            res++;
        }

        try
        {
            this.array[2] = 0;
        }
        catch (IndexOutOfBoundsException e)
        {
            res++;
        }

        try
        {
            this.array[2] = 1;
        }
        catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            this.array[2] = 0;
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
            this.array[2] = 0;
        }
        catch (Throwable e)
        {
            res++;
        }

        return (short)res;
    }
}
