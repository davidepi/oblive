package testclasses.arrays.unidimensional;

import it.se.obfuscator.Obfuscate;

public class LoadArrayChar
{
    private char[] array;

    public LoadArrayChar()
    {
        this.array = new char[]{'a','b','c','d','光','e','f','g'};
    }

    @Obfuscate
    public char getVal()
    {
        return this.array[4];
    }

}
