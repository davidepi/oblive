package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;

public class LengthArrayDouble
{
    private double[] array;

    public LengthArrayDouble()
    {
        this.array = new double[79];
    }

    @Obfuscation
    public int getLen()
    {
        return this.array.length;
    }

}
