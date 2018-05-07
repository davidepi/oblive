package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;

public class LoadArrayChar
{
    private char[] array;

    public LoadArrayChar()
    {
        this.array = new char[]{'a','b','c','d','光','e','f','g'};
    }

    @Obfuscation
    public char getVal()
    {
        return this.array[4];
    }

}
