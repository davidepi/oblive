package testclasses.exceptions.negativesize.multidimensional;

import it.se.obfuscator.Obfuscate;

public class ThrowNegativeArraySizeDouble
{
    private double array[][][];
    public ThrowNegativeArraySizeDouble()
    {

    }

    @Obfuscate
    public int exec()
    {
        this.array = new double[-1][1][1];
        return 0;
    }
}
