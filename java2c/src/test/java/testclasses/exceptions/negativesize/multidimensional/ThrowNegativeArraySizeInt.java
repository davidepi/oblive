package testclasses.exceptions.negativesize.multidimensional;

import it.se.obfuscator.Obfuscate;

public class ThrowNegativeArraySizeInt
{
    private int array[][][];
    public ThrowNegativeArraySizeInt()
    {

    }

    @Obfuscate
    public int exec()
    {
        this.array = new int[-1][1][1];
        return 0;
    }
}
