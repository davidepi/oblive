package testclasses.arrays;

import it.se.obfuscator.Obfuscate;

public class LengthArrayShortSingleDim
{
    private short[] array;

    public LengthArrayShortSingleDim()
    {
        this.array = new short[85];
    }

    @Obfuscate
    public int getLen()
    {
        return this.array.length;
    }

}
