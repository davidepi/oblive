package testclasses.arrays.multidimensional;

import it.se.obfuscator.Obfuscate;

public class LengthArrayShort
{
    private short[][] array;

    public LengthArrayShort()
    {
        this.array = new short[3][2];
    }

    @Obfuscate
    public int getLen()
    {
        return this.array.length;
    }

}
