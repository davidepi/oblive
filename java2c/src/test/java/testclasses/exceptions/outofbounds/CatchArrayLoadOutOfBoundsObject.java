package testclasses.exceptions.outofbounds;

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

        return ((Integer)res).toString();
    }
}
