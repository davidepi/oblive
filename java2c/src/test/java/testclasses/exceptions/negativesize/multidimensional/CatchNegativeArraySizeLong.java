package testclasses.exceptions.negativesize.multidimensional;

import eu.fbk.hardening.annotation.Obfuscation;

public class CatchNegativeArraySizeLong
{
    private long array[][][][];
    public CatchNegativeArraySizeLong()
    {

    }

    @Obfuscation
    public int exec()
    {
        int res = 0;
        try
        {
            this.array = new long[-1][1][1][1];
            res+=1000;
        }
        catch (NegativeArraySizeException e)
        {
            res++;
        }

        try
        {
            this.array = new long[1][-1][1][1];
            res+=1000;
        }
        catch(RuntimeException e)
        {
            res++;
        }

        try
        {
            this.array = new long[1][1][-1][1];
            res+=1000;
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
            this.array = new long[1][1][1][-1];
            res+=1000;
        }
        catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
