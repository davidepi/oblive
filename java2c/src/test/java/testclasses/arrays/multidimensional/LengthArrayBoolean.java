package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotation.Obfuscation;

public class LengthArrayBoolean
{
    private boolean[][] array;

    public LengthArrayBoolean()
    {
        this.array = new boolean[3][2];
    }

    @Obfuscation
    public int getLen()
    {
        return this.array.length;
    }

}
