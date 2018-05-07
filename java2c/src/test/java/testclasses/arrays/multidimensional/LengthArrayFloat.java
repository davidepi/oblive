package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotation.Obfuscation;

public class LengthArrayFloat
{
    private float[][] array;

    public LengthArrayFloat()
    {
        this.array = new float[3][2];
    }

    @Obfuscation
    public int getLen()
    {
        return this.array.length;
    }

}
