package testclasses.arrays.unidimensional;

import it.se.obfuscator.Obfuscate;

public class LoadArrayObject
{
    private String[] array;

    public LoadArrayObject()
    {
        this.array = new String[]{"hello","world"};
    }

    @Obfuscate
    public String getVal()
    {
        return this.array[1];
    }

}
