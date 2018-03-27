package testclasses.exceptions.negativesize.multidimensional;

import it.se.obfuscator.Obfuscate;

public class ThrowNegativeArraySizeShort
{
    private short array[][][];
    public ThrowNegativeArraySizeShort()
    {

    }

    @Obfuscate
    public int exec()
    {
        this.array = new short[-1][1][1];
        return 0;
    }
}
