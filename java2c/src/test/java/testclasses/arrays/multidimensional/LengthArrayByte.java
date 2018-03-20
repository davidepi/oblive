package testclasses.arrays.multidimensional;

import it.se.obfuscator.Obfuscate;

public class LengthArrayByte
{
    private byte[][] array;

    public LengthArrayByte()
    {
        this.array = new byte[3][2];
    }

    @Obfuscate
    public int getLen()
    {
        return this.array.length;
    }

}
