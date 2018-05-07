package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;

public class LoadArrayObject
{
    private String[] array;

    public LoadArrayObject()
    {
        this.array = new String[]{"hello","world"};
    }

    @Obfuscation
    public String getVal()
    {
        return this.array[1];
    }

}
