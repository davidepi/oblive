package testclasses.arrays;

import it.se.obfuscator.Obfuscate;

import java.util.ArrayList;

public class StoreArrayDoubleSingleDim
{
    private double[] array;

    public StoreArrayDoubleSingleDim()
    {
        this.array = new double[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
    }

    @Obfuscate
    public void setVal(int i, double val)
    {
        this.array[i] = val;
    }

    public ArrayList<Double> test()
    {
        ArrayList<Double> retval = new ArrayList<>();
        int i = 4;
        this.setVal(i,10.52f);
        //assert that also the rest of the array is unchanged
        for(int j=0;j<this.array.length;j++)
            retval.add(array[j]);
        return retval;
    }

}
