package testclasses.arrays;

import it.se.obfuscator.Obfuscate;

public class LoadArrayShortSingleDim
{
    private short[] array;

    public LoadArrayShortSingleDim()
    {
        this.array = new short[]{1000,2000,3000,4000,5000,6000,7000,8000};
    }

    @Obfuscate
    public short getVal()
    {
        return this.array[4];
    }

}
