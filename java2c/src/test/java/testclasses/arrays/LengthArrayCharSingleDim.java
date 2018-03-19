package testclasses.arrays;

import it.se.obfuscator.Obfuscate;

public class LengthArrayCharSingleDim
{
    private char[] array;

    public LengthArrayCharSingleDim()
    {
        this.array = new char[95];
    }

    @Obfuscate
    public int getLen()
    {
        return this.array.length;
    }

}
