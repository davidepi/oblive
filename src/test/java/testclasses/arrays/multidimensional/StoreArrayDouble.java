package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

import java.util.ArrayList;

public class StoreArrayDouble
{
    private double[][] array;

    public StoreArrayDouble()
    {
        this.array = new double[2][10];
        this.array[0] = new double[]{-1., -1., -1., -1., -1., -1., -1., -1., -1., -1.};
        this.array[1] = new double[]{-1., -1., -1., -1., -1., -1., -1., -1., -1., -1.};
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public void setVal(int i, int j, double val)
    {
        this.array[i][j] = val;
    }

    public ArrayList<ArrayList<Double>> test()
    {
        ArrayList<ArrayList<Double>> retval = new ArrayList<>();
        int k = 1;
        int l = 4;
        this.setVal(k, l, 13.5);
        //assert that also the rest of the array is unchanged
        double[][] native_array = array;
        for (int i = 0; i < native_array.length; i++)
        {
            ArrayList<Double> current = new ArrayList<>(3);
            retval.add(current);

        }
        return retval;
    }

}
