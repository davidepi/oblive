package testclasses.exceptions.negativesize.multidimensional;

import it.se.obfuscator.Obfuscate;

public class CatchNegativeArraySizeObject
{
    private Object array[][][][];
    public CatchNegativeArraySizeObject()
    {

    }

    @Obfuscate
    public int exec()
    {
        int res = 0;
        try
        {
            this.array = new String[-1][1][1][1];
        }
        catch (NegativeArraySizeException e)
        {
            res++;
        }

        try
        {
            this.array = new String[1][-1][1][1];
        }
        catch(RuntimeException e)
        {
            res++;
        }

        try
        {
            this.array = new String[1][1][-1][1];
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
            this.array = new String[1][-1][1][1];
        }
        catch (Throwable e)
        {
            res++;
        }

        try
        {
            this.array = new String[1][1][1][-1];
        }
        catch (NullPointerException e)
        {
            res++;
        }

        return res;
    }
}
