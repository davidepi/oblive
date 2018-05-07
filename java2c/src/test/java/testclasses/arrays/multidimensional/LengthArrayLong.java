package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotation.Obfuscation;

public class LengthArrayLong
{
    private long[][] array;

    public LengthArrayLong()
    {
        this.array = new long[3][2];
    }

    @Obfuscation
    public int getLen()
    {
        return this.array.length;
    }

}
