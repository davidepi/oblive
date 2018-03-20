package testclasses.arrays.unidimensional;

import it.se.obfuscator.Obfuscate;

public class LoadArrayLong
{
    private long[] array;

    public LoadArrayLong()
    {
        this.array = new long[]{1000000000L,2000000000L,3000000000L,4000000000L,500000000000L};
    }

    @Obfuscate
    public long getVal()
    {
        return this.array[4];
    }

}
