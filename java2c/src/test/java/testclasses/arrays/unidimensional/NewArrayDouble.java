package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;

import java.util.ArrayList;

public class NewArrayDouble
{
    public NewArrayDouble()
    {

    }

    @Obfuscation
    public double[] getArray()
    {
        return new double[10];
    }

    public ArrayList<Double> test()
    {
        ArrayList<Double> res = new ArrayList<Double>(10);
        double[] native_array = this.getArray();
        for(int i=0;i<native_array.length;i++)
            res.add(native_array[i]);
        return res;
    }

}
