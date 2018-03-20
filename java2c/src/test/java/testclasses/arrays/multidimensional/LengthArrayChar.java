package testclasses.arrays.multidimensional;

import it.se.obfuscator.Obfuscate;

public class LengthArrayChar
{
    private char[][] array;

    public LengthArrayChar()
    {
        this.array = new char[3][2];
    }

    @Obfuscate
    public int getLen()
    {
        return this.array.length;
    }

}
