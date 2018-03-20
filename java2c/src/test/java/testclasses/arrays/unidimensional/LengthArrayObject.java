package testclasses.arrays.unidimensional;

import it.se.obfuscator.Obfuscate;

public class LengthArrayObject
{
    private String[] array;

    public LengthArrayObject()
    {
        this.array = new String[3];
    }

    @Obfuscate
    public int getLen()
    {
        return this.array.length;
    }

}
