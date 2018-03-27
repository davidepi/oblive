package testclasses.exceptions;

import it.se.obfuscator.Obfuscate;

public class CatchArrayStoreException
{
    private Object array[];
    public CatchArrayStoreException()
    {
        this.array = new String[2];
        this.array[0] = "hello";
        this.array[1] = "world";
    }

    @Obfuscate
    public int exec()
    {
        int res = 0;
        try
        {
            this.array[1] = 1;
        }
        catch (ArrayStoreException e)
        {
            res++;
        }

        try
        {
            this.array[1] = 1;
        }
        catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            this.array[1] = 1;
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
            this.array[1] = 1;
        }
        catch (Throwable e)
        {
            res++;
        }
        return res;
    }
}
