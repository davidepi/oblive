package testclasses.exceptions.negativesize.multidimensional;

import eu.fbk.hardening.annotation.Obfuscation;

public class CatchNegativeArraySizeObject
{
    private Object array[][][][];
    public CatchNegativeArraySizeObject()
    {

    }

    @Obfuscation
    public int exec()
    {
        int res = 0;
        try
        {
            this.array = new String[-1][1][1][1];
            res+=1000;
        }
        catch (NegativeArraySizeException e)
        {
            res++;
        }

        try
        {
            this.array = new String[1][-1][1][1];
            res+=1000;
        }
        catch(RuntimeException e)
        {
            res++;
        }

        try
        {
            this.array = new String[1][1][-1][1];
            res+=1000;
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
            this.array = new String[1][-1][1][1];
            res+=1000;
        }
        catch (Throwable e)
        {
            res++;
        }

        try
        {
            this.array = new String[1][1][1][-1];
            res+=1000;
        }
        catch (NullPointerException e)
        {
            res++;
        }

        return res;
    }
}
