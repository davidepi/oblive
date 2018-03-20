package testclasses.arrays.unidimensional;

import it.se.obfuscator.Obfuscate;

public class LengthArrayFloat
{
    private float[] array;

    public LengthArrayFloat()
    {
        this.array = new float[84];
    }

    @Obfuscate
    public int getLen()
    {
        return this.array.length;
    }

}
