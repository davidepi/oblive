package testclasses.arrays;

import it.se.obfuscator.Obfuscate;

public class LengthArrayByteSingleDim
{
    private byte[] array;

    public LengthArrayByteSingleDim()
    {
        this.array = new byte[84];
    }

    @Obfuscate
    public int getLen()
    {
        return this.array.length;
    }

}
