package testclasses.arrays.unidimensional;

import it.se.obfuscator.Obfuscate;

public class LengthArrayDouble
{
    private double[] array;

    public LengthArrayDouble()
    {
        this.array = new double[79];
    }

    @Obfuscate
    public int getLen()
    {
        return this.array.length;
    }

}
