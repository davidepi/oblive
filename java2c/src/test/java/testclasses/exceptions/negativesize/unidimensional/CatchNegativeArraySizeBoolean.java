package testclasses.exceptions.negativesize.unidimensional;

import it.se.obfuscator.Obfuscate;

public class CatchNegativeArraySizeBoolean
{
    private boolean array[];
    public CatchNegativeArraySizeBoolean()
    {

    }

    @Obfuscate
    public int exec()
    {
        int res = 0;
        try
        {
            this.array = new boolean[-1];
            res+=1000;
        }
        catch (NegativeArraySizeException e)
        {
            res++;
        }

        try
        {
            this.array = new boolean[-1];
            res+=1000;
        }
        catch(RuntimeException e)
        {
            res++;
        }

        try
        {
            this.array = new boolean[-1];
            res+=1000;
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
            this.array = new boolean[-1];
            res+=1000;
        }
        catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
