package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class LoadArrayObject
{
    private String[] array;

    public LoadArrayObject()
    {
        this.array = new String[]{"hello", "world"};
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public String getVal()
    {
        return this.array[1];
    }

}
