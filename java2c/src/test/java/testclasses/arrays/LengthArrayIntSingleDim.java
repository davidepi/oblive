package testclasses.arrays;

import it.se.obfuscator.Obfuscate;

import java.util.ArrayList;

public class LengthArrayIntSingleDim
{
    private int[] array;

    public LengthArrayIntSingleDim()
    {
        this.array = new int[87];
    }

    @Obfuscate
    public int getLen()
    {
        return this.array.length;
    }

}
