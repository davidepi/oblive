package testclasses.arrays.multidimensional;

import it.se.obfuscator.Obfuscate;

public class LengthArrayObject
{
    private String[][] array;

    public LengthArrayObject()
    {
        this.array = new String[3][2];
    }

    @Obfuscate
    public int getLen()
    {
        return this.array.length;
    }

}
