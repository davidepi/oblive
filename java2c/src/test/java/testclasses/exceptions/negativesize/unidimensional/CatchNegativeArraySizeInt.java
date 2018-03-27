package testclasses.exceptions.negativesize.unidimensional;

import it.se.obfuscator.Obfuscate;

public class CatchNegativeArraySizeInt
{
    private int array[];
    public CatchNegativeArraySizeInt()
    {

    }

    @Obfuscate
    public int exec()
    {
        int res = 0;
        try
        {
            this.array = new int[-1];
        }
        catch (NegativeArraySizeException e)
        {
            res++;
        }

        try
        {
            this.array = new int[-1];
        }
        catch(RuntimeException e)
        {
            res++;
        }

        try
        {
            this.array = new int[-1];
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
            this.array = new int[-1];
        }
        catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
