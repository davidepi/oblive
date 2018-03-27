package testclasses.exceptions.negativesize.multidimensional;

import it.se.obfuscator.Obfuscate;

public class ThrowNegativeArraySizeBoolean
{
    private boolean array[][][];
    public ThrowNegativeArraySizeBoolean()
    {

    }

    @Obfuscate
    public int exec()
    {
        this.array = new boolean[-1][1][1];
        return 0;
    }
}
