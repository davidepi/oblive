package testclasses.arrays.unidimensional;

import it.se.obfuscator.Obfuscate;

public class LoadArrayInt
{
    private int[] array;

    public LoadArrayInt()
    {
        this.array = new int[]{1000000000,1100000000,1200000000,1300000000,1400000000,1500000000,1600000000,1700000000,1800000000,1900000000};
    }

    @Obfuscate
    public int getVal()
    {
        return this.array[4];
    }

}
