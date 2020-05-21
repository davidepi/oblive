package testclasses.arrays.multidimensional;

import it.oblive.annotations.NativeObfuscation;

import java.util.ArrayList;

public class NewArrayLongThreeDims {
    public NewArrayLongThreeDims() {

    }

    @NativeObfuscation
    public long[][][] getArray() {
        return new long[2][3][4];
    }

    public ArrayList<ArrayList<ArrayList<Long>>> test() {
        ArrayList<ArrayList<ArrayList<Long>>> res = new ArrayList<>(2);
        long[][][] native_array = this.getArray();
        for (int i = 0; i < native_array.length; i++) {
            ArrayList<ArrayList<Long>> current = new ArrayList<>(3);
            for (int j = 0; j < native_array[i].length; j++) {
                current.add(new ArrayList<Long>(4));
            }
            res.add(current);
        }
        return res;
    }

}
