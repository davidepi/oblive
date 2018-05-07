package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;

public class LoadArrayByte
{
    private byte[] array;

    public LoadArrayByte()
    {
        this.array = new byte[]{0,1,2,3,4,5,6,7,8,9,0};
    }

    @Obfuscation
    public byte getVal()
    {
        return this.array[4];
    }

}
