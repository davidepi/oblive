package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotation.Obfuscation;

public class LengthArrayShort
{
    private short[][] array;

    public LengthArrayShort()
    {
        this.array = new short[3][2];
    }

    @Obfuscation
    public int getLen()
    {
        return this.array.length;
    }

}
