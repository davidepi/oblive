package testclasses.exceptions.negativesize.multidimensional;

import it.se.obfuscator.Obfuscate;

public class ThrowNegativeArraySizeByte
{
    private byte array[][][];
    public ThrowNegativeArraySizeByte()
    {

    }

    @Obfuscate
    public int exec()
    {
        this.array = new byte[-1][1][1];
        return 0;
    }
}
