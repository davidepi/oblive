package testclasses.arrays;

import it.se.obfuscator.Obfuscate;

public class LoadArrayCharSingleDim
{
    private char[] array;

    public LoadArrayCharSingleDim()
    {
        this.array = new char[]{'a','b','c','d','光','e','f','g'};
    }

    @Obfuscate
    public char getVal()
    {
        return this.array[4];
    }

}
