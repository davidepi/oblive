package testclasses.exceptions.negativesize.multidimensional;

import it.se.obfuscator.Obfuscate;

public class ThrowNegativeArraySizeLong
{
    private long array[][][];
    public ThrowNegativeArraySizeLong()
    {

    }

    @Obfuscate
    public int exec()
    {
        this.array = new long[-1][1][1];
        return 0;
    }
}
