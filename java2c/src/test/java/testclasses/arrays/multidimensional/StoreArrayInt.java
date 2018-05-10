package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

import java.util.ArrayList;

public class StoreArrayInt
{
    private int[][] array;

    public StoreArrayInt()
    {
        this.array = new int[2][10];
        this.array[0] = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        this.array[1] = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public void setVal(int i, int j, int val)
    {
        this.array[i][j] = val;
    }

    public ArrayList<ArrayList<Integer>> test()
    {
        ArrayList<ArrayList<Integer>> retval = new ArrayList<>();
        int k = 1;
        int l = 4;
        this.setVal(k, l, 1000000000);
        //assert that also the rest of the array is unchanged
        int[][] native_array = array;
        for (int i = 0; i < native_array.length; i++)
        {
            ArrayList<Integer> current = new ArrayList<>(3);
            retval.add(current);

        }
        return retval;
    }

}
