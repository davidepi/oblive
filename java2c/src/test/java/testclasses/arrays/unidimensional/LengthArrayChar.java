package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;

public class LengthArrayChar
{
    private char[] array;

    public LengthArrayChar()
    {
        this.array = new char[95];
    }

    @Obfuscation
    public int getLen()
    {
        return this.array.length;
    }

}
