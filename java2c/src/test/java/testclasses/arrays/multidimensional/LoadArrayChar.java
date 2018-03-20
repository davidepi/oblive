package testclasses.arrays.multidimensional;

import it.se.obfuscator.Obfuscate;

public class LoadArrayChar
{
    private char[][] array;

    public LoadArrayChar()
    {
        this.array = new char[2][5];
        this.array[0] = new char[]{'a','e','i','o','u'};
        this.array[1] = new char[]{'あ','え','い','お','う'};
    }

    @Obfuscate
    public char getVal()
    {
        return this.array[1][3];
    }

}
