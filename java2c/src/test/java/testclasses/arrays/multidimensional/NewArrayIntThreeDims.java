package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

import java.util.ArrayList;

public class NewArrayIntThreeDims
{
    public NewArrayIntThreeDims()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int[][][] getArray()
    {
        return new int[2][3][4];
    }

    public ArrayList<ArrayList<ArrayList<Integer>>> test()
    {
        ArrayList<ArrayList<ArrayList<Integer>>> res = new ArrayList<>(2);
        int[][][] native_array = this.getArray();
        for (int i = 0; i < native_array.length; i++)
        {
            ArrayList<ArrayList<Integer>> current = new ArrayList<>(3);
            for (int j = 0; j < native_array[i].length; j++)
            {
                current.add(new ArrayList<Integer>(4));
            }
            res.add(current);
        }
        return res;
    }

}
