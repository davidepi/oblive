package testclasses.arrays.unidimensional;

import it.se.obfuscator.Obfuscate;

public class LengthArrayChar
{
    private char[] array;

    public LengthArrayChar()
    {
        this.array = new char[95];
    }

    @Obfuscate
    public int getLen()
    {
        return this.array.length;
    }

}
