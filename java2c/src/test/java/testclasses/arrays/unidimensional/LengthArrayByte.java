package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;

public class LengthArrayByte
{
    private byte[] array;

    public LengthArrayByte()
    {
        this.array = new byte[84];
    }

    @Obfuscation
    public int getLen()
    {
        return this.array.length;
    }

}
