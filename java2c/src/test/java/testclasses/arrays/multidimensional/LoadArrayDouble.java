package testclasses.arrays.multidimensional;

import it.se.obfuscator.Obfuscate;

public class LoadArrayDouble
{
    private double[][] array;

    public LoadArrayDouble()
    {
        this.array = new double[2][3];
        this.array[0] = new double[]{.1,.2,.3};
        this.array[1] = new double[]{.4,.5,.6};
    }

    @Obfuscate
    public double getVal()
    {
        return this.array[1][0];
    }

}
