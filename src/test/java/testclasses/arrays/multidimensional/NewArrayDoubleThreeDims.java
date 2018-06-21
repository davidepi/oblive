package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

import java.util.ArrayList;

public class NewArrayDoubleThreeDims
{
    public NewArrayDoubleThreeDims()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public double[][][] getArray()
    {
        return new double[2][3][4];
    }

    public ArrayList<ArrayList<ArrayList<Double>>> test()
    {
        ArrayList<ArrayList<ArrayList<Double>>> res = new ArrayList<>(2);
        double[][][] native_array = this.getArray();
        for (int i = 0; i < native_array.length; i++)
        {
            ArrayList<ArrayList<Double>> current = new ArrayList<>(3);
            for (int j = 0; j < native_array[i].length; j++)
            {
                current.add(new ArrayList<Double>(4));
            }
            res.add(current);
        }
        return res;
    }

}
