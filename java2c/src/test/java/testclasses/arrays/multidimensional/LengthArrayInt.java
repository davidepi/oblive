package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class LengthArrayInt
{
    private int[][] array;

    public LengthArrayInt()
    {
        this.array = new int[3][2];
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int getLen()
    {
        return this.array.length;
    }

}
