package testclasses.exceptions.negativesize.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;

public class CatchNegativeArraySizeShort
{
    private short array[];
    public CatchNegativeArraySizeShort()
    {

    }

    @Obfuscation
    public int exec()
    {
        int res = 0;
        try
        {
            this.array = new short[-1];
            res+=1000;
        }
        catch (NegativeArraySizeException e)
        {
            res++;
        }

        try
        {
            this.array = new short[-1];
            res+=1000;
        }
        catch(RuntimeException e)
        {
            res++;
        }

        try
        {
            this.array = new short[-1];
            res+=1000;
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
            this.array = new short[-1];
            res+=1000;
        }
        catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
