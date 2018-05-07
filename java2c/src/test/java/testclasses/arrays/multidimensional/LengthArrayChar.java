package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotation.Obfuscation;

public class LengthArrayChar
{
    private char[][] array;

    public LengthArrayChar()
    {
        this.array = new char[3][2];
    }

    @Obfuscation
    public int getLen()
    {
        return this.array.length;
    }

}
