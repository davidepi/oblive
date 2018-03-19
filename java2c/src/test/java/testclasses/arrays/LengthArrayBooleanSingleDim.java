package testclasses.arrays;

import it.se.obfuscator.Obfuscate;

public class LengthArrayBooleanSingleDim
{
    private boolean[] array;

    public LengthArrayBooleanSingleDim()
    {
        this.array = new boolean[61];
    }

    @Obfuscate
    public int getLen()
    {
        return this.array.length;
    }

}
