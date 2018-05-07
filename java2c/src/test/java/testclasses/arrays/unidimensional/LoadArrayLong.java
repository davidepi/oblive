package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;

public class LoadArrayLong
{
    private long[] array;

    public LoadArrayLong()
    {
        this.array = new long[]{1000000000L,2000000000L,3000000000L,4000000000L,500000000000L};
    }

    @Obfuscation
    public long getVal()
    {
        return this.array[4];
    }

}
