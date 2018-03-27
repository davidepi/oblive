package testclasses.exceptions.outofbounds;

import it.se.obfuscator.Obfuscate;

public class CatchArrayLoadOutOfBoundsBoolean
{
    private boolean array[];
    public CatchArrayLoadOutOfBoundsBoolean()
    {
        this.array = new boolean[2];
    }

    @Obfuscate
    public int exec()
    {
        int res=0;

        try
        {
            return this.array[2]?1:0;
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            res++;
        }

        try
        {
            return this.array[2]?1:0;
        }
        catch (IndexOutOfBoundsException e)
        {
            res++;
        }

        try
        {
            return this.array[2]?1:0;
        }
        catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            return this.array[2]?1:0;
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

        try
        {
            return this.array[2]?1:0;
        }
        catch (NullPointerException e)
        {
            res++;
        }

        return res;
    }
}
