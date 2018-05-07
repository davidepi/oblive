package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotation.Obfuscation;

import java.util.ArrayList;

public class NewArrayInt
{
    public NewArrayInt()
    {

    }

    @Obfuscation
    public int[][] getArray()
    {
        return new int[2][3];
    }

    public ArrayList<ArrayList<Integer>> test()
    {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>(2);
        int[][] native_array = this.getArray();
        for(int i=0;i<native_array.length;i++)
        {
            ArrayList<Integer> current = new ArrayList<>(3);
            res.add(current);

        }
        return res;
    }

}
