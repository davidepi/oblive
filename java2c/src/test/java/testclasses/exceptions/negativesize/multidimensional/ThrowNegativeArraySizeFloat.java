package testclasses.exceptions.negativesize.multidimensional;

import it.se.obfuscator.Obfuscate;

public class ThrowNegativeArraySizeFloat
{
    private float array[][][];
    public ThrowNegativeArraySizeFloat()
    {

    }

    @Obfuscate
    public int exec()
    {
        this.array = new float[-1][1][1];
        return 0;
    }
}
