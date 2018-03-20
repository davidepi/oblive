package testclasses.arrays.unidimensional;

import it.se.obfuscator.Obfuscate;

public class LoadArrayByte
{
    private byte[] array;

    public LoadArrayByte()
    {
        this.array = new byte[]{0,1,2,3,4,5,6,7,8,9,0};
    }

    @Obfuscate
    public byte getVal()
    {
        return this.array[4];
    }

}
