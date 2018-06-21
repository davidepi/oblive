package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

import java.util.ArrayList;

public class StoreArrayBoolean
{
    private boolean[][] array;

    public StoreArrayBoolean()
    {
        this.array = new boolean[2][10];
        this.array[0] = new boolean[]{true, true, true, true, true, true, true, true, true, true};
        this.array[1] = new boolean[]{true, true, true, true, true, true, true, true, true, true};
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public void setVal(int i, int j, boolean val)
    {
        this.array[i][j] = val;
    }

    public ArrayList<ArrayList<Boolean>> test()
    {
        ArrayList<ArrayList<Boolean>> retval = new ArrayList<>();
        int k = 1;
        int l = 4;
        this.setVal(k, l, false);
        //assert that also the rest of the array is unchanged
        boolean[][] native_array = array;
        for (int i = 0; i < native_array.length; i++)
        {
            ArrayList<Boolean> current = new ArrayList<>(3);
            retval.add(current);

        }
        return retval;
    }

}
