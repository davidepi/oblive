package testclasses.exceptions.outofbounds.arraystore;

import it.se.obfuscator.Obfuscate;

public class CatchArrayStoreOutOfBoundsObject
{
    private String array[];
    public CatchArrayStoreOutOfBoundsObject()
    {
        this.array = new String[2];
    }

    @Obfuscate
    public String exec()
    {
        int res=0;

        try
        {
            this.array[2] = "str0";
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            res++;
        }

        try
        {
            this.array[2] = "str1";
        }
        catch (IndexOutOfBoundsException e)
        {
            res++;
        }

        try
        {
            this.array[2] = "str2";
        }
        catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            this.array[2] = "str3";
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
            this.array[2] = "str4";
        }
        catch (Throwable e)
        {
            res++;
        }

        return ((Integer)res).toString();
    }
}
