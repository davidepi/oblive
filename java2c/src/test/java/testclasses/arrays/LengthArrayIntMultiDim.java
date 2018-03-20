package testclasses.arrays;

import it.se.obfuscator.Obfuscate;

public class LengthArrayIntMultiDim
{
    private int[][] array;

    public LengthArrayIntMultiDim()
    {
        this.array = new int[3][2];
    }

    @Obfuscate
    public int getLen()
    {
        return this.array.length;
    }

}
