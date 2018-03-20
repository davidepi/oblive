package testclasses.arrays.unidimensional;

import it.se.obfuscator.Obfuscate;

import java.util.ArrayList;

public class LengthArrayInt
{
    private int[] array;

    public LengthArrayInt()
    {
        this.array = new int[87];
    }

    @Obfuscate
    public int getLen()
    {
        return this.array.length;
    }

}
