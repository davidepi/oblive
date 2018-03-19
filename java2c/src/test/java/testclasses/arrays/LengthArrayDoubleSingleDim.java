package testclasses.arrays;

import it.se.obfuscator.Obfuscate;

public class LengthArrayDoubleSingleDim
{
    private double[] array;

    public LengthArrayDoubleSingleDim()
    {
        this.array = new double[79];
    }

    @Obfuscate
    public int getLen()
    {
        return this.array.length;
    }

}
