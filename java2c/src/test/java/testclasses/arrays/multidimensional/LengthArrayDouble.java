package testclasses.arrays.multidimensional;

import it.se.obfuscator.Obfuscate;

public class LengthArrayDouble
{
    private double[][] array;

    public LengthArrayDouble()
    {
        this.array = new double[3][2];
    }

    @Obfuscate
    public int getLen()
    {
        return this.array.length;
    }

}
