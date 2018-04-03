package testclasses.exceptions.outofbounds.arraystore;

import it.se.obfuscator.Obfuscate;

public class CatchArrayStoreOutOfBoundsBoolean
{
    private boolean array[];
    public CatchArrayStoreOutOfBoundsBoolean()
    {
        this.array = new boolean[2];
    }

    @Obfuscate
    public int exec()
    {
        int res=0;

        try
        {
            this.array[2] = true;
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            res++;
        }

        try
        {
            this.array[2] = false;
        }
        catch (IndexOutOfBoundsException e)
        {
            res++;
        }

        try
        {
            this.array[2] = true;
        }
        catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            this.array[2] = false;
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
            return this.array[2]?1:0;
        }
        catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
