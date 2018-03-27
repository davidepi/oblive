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
        }
        catch (NegativeArraySizeException e)
        {
            res++;
        }

        try
        {
            this.array = new boolean[-1];
        }
        catch(RuntimeException e)
        {
            res++;
        }

        try
        {
            this.array = new boolean[-1];
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
            this.array = new boolean[-1];
        }
        catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
