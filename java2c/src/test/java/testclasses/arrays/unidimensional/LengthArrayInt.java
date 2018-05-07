package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;

public class LengthArrayInt
{
    private int[] array;

    public LengthArrayInt()
    {
        this.array = new int[87];
    }

    @Obfuscation
    public int getLen()
    {
        return this.array.length;
    }

}
