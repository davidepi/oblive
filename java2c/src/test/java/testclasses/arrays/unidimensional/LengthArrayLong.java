package testclasses.arrays.unidimensional;

import it.se.obfuscator.Obfuscate;

public class LengthArrayLong
{
    private long[] array;

    public LengthArrayLong()
    {
        this.array = new long[93];
    }

    @Obfuscate
    public int getLen()
    {
        return this.array.length;
    }

}
