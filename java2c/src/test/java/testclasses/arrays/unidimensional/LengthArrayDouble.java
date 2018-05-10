package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class LengthArrayDouble
{
    private double[] array;

    public LengthArrayDouble()
    {
        this.array = new double[79];
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int getLen()
    {
        return this.array.length;
    }

}
