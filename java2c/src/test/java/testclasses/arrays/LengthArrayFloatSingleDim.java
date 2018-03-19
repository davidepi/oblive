package testclasses.arrays;

import it.se.obfuscator.Obfuscate;

public class LengthArrayFloatSingleDim
{
    private float[] array;

    public LengthArrayFloatSingleDim()
    {
        this.array = new float[84];
    }

    @Obfuscate
    public int getLen()
    {
        return this.array.length;
    }

}
