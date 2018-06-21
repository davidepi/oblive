package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class LoadArrayDouble
{
    private double[] array;

    public LoadArrayDouble()
    {
        this.array = new double[]{.1, .2, .3, .4, .5, .6, .7, .8, .9, 1e110};
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public double getVal()
    {
        return this.array[9];
    }

}
