package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;

public class LengthArrayFloat
{
    private float[] array;

    public LengthArrayFloat()
    {
        this.array = new float[84];
    }

    @Obfuscation
    public int getLen()
    {
        return this.array.length;
    }

}
