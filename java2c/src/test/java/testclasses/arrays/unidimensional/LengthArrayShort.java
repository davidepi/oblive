package testclasses.arrays.unidimensional;

import it.se.obfuscator.Obfuscate;

public class LengthArrayShort
{
    private short[] array;

    public LengthArrayShort()
    {
        this.array = new short[85];
    }

    @Obfuscate
    public int getLen()
    {
        return this.array.length;
    }

}
