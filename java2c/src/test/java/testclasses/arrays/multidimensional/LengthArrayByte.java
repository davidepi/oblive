package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotation.Obfuscation;

public class LengthArrayByte
{
    private byte[][] array;

    public LengthArrayByte()
    {
        this.array = new byte[3][2];
    }

    @Obfuscation
    public int getLen()
    {
        return this.array.length;
    }

}
