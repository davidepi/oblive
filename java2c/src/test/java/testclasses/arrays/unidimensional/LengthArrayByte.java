package testclasses.arrays.unidimensional;

import it.se.obfuscator.Obfuscate;

public class LengthArrayByte
{
    private byte[] array;

    public LengthArrayByte()
    {
        this.array = new byte[84];
    }

    @Obfuscate
    public int getLen()
    {
        return this.array.length;
    }

}
