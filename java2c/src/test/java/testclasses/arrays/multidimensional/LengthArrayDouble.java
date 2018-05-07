package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotation.Obfuscation;

public class LengthArrayDouble
{
    private double[][] array;

    public LengthArrayDouble()
    {
        this.array = new double[3][2];
    }

    @Obfuscation
    public int getLen()
    {
        return this.array.length;
    }

}
