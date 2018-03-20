package testclasses.arrays;

import it.se.obfuscator.Obfuscate;

public class LengthArrayObjectSingleDim
{
    private String[] array;

    public LengthArrayObjectSingleDim()
    {
        this.array = new String[3];
    }

    @Obfuscate
    public int getLen()
    {
        return this.array.length;
    }

}
