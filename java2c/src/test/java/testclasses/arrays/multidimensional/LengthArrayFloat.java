package testclasses.arrays.multidimensional;

import it.se.obfuscator.Obfuscate;

public class LengthArrayFloat
{
    private float[][] array;

    public LengthArrayFloat()
    {
        this.array = new float[3][2];
    }

    @Obfuscate
    public int getLen()
    {
        return this.array.length;
    }

}
