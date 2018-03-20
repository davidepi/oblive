package testclasses.arrays;

import it.se.obfuscator.Obfuscate;

import java.util.ArrayList;

public class NewArrayIntArraySingleDim
{
    public NewArrayIntArraySingleDim()
    {

    }

    @Obfuscate
    public int[][] getArray()
    {
        return new int[2][];
    }

    public ArrayList<int[]> test()
    {
        ArrayList<int[]> res = new ArrayList<>(2);
        int[][] native_array = this.getArray();
        for(int i=0;i<native_array.length;i++)
        {
            res.add(native_array[i]);
        }
        return res;
    }

}
