package testclasses.arrays.multidimensional;

import it.se.obfuscator.Obfuscate;

public class LengthArrayLong
{
    private long[][] array;

    public LengthArrayLong()
    {
        this.array = new long[3][2];
    }

    @Obfuscate
    public int getLen()
    {
        return this.array.length;
    }

}
