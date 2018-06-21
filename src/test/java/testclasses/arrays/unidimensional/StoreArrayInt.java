package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

import java.util.ArrayList;

public class StoreArrayInt
{
    private int[] array;

    public StoreArrayInt()
    {
        this.array = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public void setVal(int i, int val)
    {
        this.array[i] = val;
    }

    public ArrayList<Integer> test()
    {
        ArrayList<Integer> retval = new ArrayList<>();
        int i = 4;
        this.setVal(i, 1000000000);
        //assert that also the rest of the array is unchanged
        for (int j = 0; j < this.array.length; j++)
            retval.add(array[j]);
        return retval;
    }

}
