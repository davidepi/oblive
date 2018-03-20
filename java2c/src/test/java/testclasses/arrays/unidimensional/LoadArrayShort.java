package testclasses.arrays.unidimensional;

import it.se.obfuscator.Obfuscate;

public class LoadArrayShort
{
    private short[] array;

    public LoadArrayShort()
    {
        this.array = new short[]{1000,2000,3000,4000,5000,6000,7000,8000};
    }

    @Obfuscate
    public short getVal()
    {
        return this.array[4];
    }

}
