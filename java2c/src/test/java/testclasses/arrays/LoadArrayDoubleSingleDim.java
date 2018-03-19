package testclasses.arrays;

import it.se.obfuscator.Obfuscate;

public class LoadArrayDoubleSingleDim
{
    private double[] array;

    public LoadArrayDoubleSingleDim()
    {
        this.array = new double[]{.1,.2,.3,.4,.5,.6,.7,.8,.9,1e110};
    }

    @Obfuscate
    public double getVal()
    {
        return this.array[9];
    }

}
