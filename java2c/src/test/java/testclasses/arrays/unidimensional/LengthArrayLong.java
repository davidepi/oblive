package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;

public class LengthArrayLong
{
    private long[] array;

    public LengthArrayLong()
    {
        this.array = new long[93];
    }

    @Obfuscation
    public int getLen()
    {
        return this.array.length;
    }

}
