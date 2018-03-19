package testclasses.arrays;

import it.se.obfuscator.Obfuscate;

public class LengthArrayLongSingleDim
{
    private long[] array;

    public LengthArrayLongSingleDim()
    {
        this.array = new long[93];
    }

    @Obfuscate
    public int getLen()
    {
        return this.array.length;
    }

}
