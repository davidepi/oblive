package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotation.Obfuscation;

public class LengthArrayObject
{
    private String[][] array;

    public LengthArrayObject()
    {
        this.array = new String[3][2];
    }

    @Obfuscation
    public int getLen()
    {
        return this.array.length;
    }

}
