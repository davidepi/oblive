package testclasses.arrays.multidimensional;

import it.se.obfuscator.Obfuscate;

import java.util.ArrayList;

public class NewArrayInt
{
    public NewArrayInt()
    {

    }

    @Obfuscate
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
            ArrayList<Integer> current = new ArrayList<Integer>(3);
            res.add(current);

        }
        return res;
    }

}
