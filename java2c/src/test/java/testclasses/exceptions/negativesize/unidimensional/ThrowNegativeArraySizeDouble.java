package testclasses.exceptions.negativesize.unidimensional;

import it.se.obfuscator.Obfuscate;

public class ThrowNegativeArraySizeDouble
{
    private double array[];
    public ThrowNegativeArraySizeDouble()
    {

    }

    @Obfuscate
    public int exec()
    {
        this.array = new double[-1];
        return 0;
    }
}
