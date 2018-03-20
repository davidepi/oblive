package testclasses.arrays;

import it.se.obfuscator.Obfuscate;

public class LoadArrayIntMultiDim
{
    private int[][] array;

    public LoadArrayIntMultiDim()
    {
        this.array = new int[2][3];
        this.array[0] = new int[]{1000000000,1100000000,1200000000};
        this.array[1] = new int[]{1300000000,1400000000,1500000000};
    }

    @Obfuscate
    public int getVal()
    {
        return this.array[1][2];
    }

}
