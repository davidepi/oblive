package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;

public class LengthArrayShort
{
    private short[] array;

    public LengthArrayShort()
    {
        this.array = new short[85];
    }

    @Obfuscation
    public int getLen()
    {
        return this.array.length;
    }

}
