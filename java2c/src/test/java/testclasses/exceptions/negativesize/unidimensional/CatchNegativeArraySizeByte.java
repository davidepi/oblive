package testclasses.exceptions.negativesize.unidimensional;

import it.se.obfuscator.Obfuscate;

public class CatchNegativeArraySizeByte
{
    private byte array[];
    public CatchNegativeArraySizeByte()
    {

    }

    @Obfuscate
    public int exec()
    {
        int res = 0;
        try
        {
            this.array = new byte[-1];
        }
        catch (NegativeArraySizeException e)
        {
            res++;
        }

        try
        {
            this.array = new byte[-1];
        }
        catch(RuntimeException e)
        {
            res++;
        }

        try
        {
            this.array = new byte[-1];
        }
        catch (Exception e)
        {
            res++;
        }

        try
        {
            this.array = new byte[-1];
        }
        catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
