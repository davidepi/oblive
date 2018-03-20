package testclasses.arrays.unidimensional;

import it.se.obfuscator.Obfuscate;

public class LoadArrayDouble
{
    private double[] array;

    public LoadArrayDouble()
    {
        this.array = new double[]{.1,.2,.3,.4,.5,.6,.7,.8,.9,1e110};
    }

    @Obfuscate
    public double getVal()
    {
        return this.array[9];
    }

}
