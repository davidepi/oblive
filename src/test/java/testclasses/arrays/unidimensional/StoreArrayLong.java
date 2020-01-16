package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotation.NativeObfuscation;

import java.util.ArrayList;

public class StoreArrayLong {
    private long[] array;

    public StoreArrayLong() {
        this.array = new long[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    }

    @NativeObfuscation
    public void setVal(int i, long val) {
        this.array[i] = val;
    }

    public ArrayList<Long> test() {
        ArrayList<Long> retval = new ArrayList<>();
        int i = 4;
        this.setVal(i, 10000000000L);
        //assert that also the rest of the array is unchanged
        for (int j = 0; j < this.array.length; j++)
            retval.add(array[j]);
        return retval;
    }

}
