package testclasses.arrays.multidimensional;

import it.se.obfuscator.Obfuscate;

public class LengthArrayInt
{
    private int[][] array;

    public LengthArrayInt()
    {
        this.array = new int[3][2];
    }

    @Obfuscate
    public int getLen()
    {
        return this.array.length;
    }

}
