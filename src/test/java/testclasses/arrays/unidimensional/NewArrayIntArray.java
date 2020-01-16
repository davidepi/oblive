package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotation.NativeObfuscation;

import java.util.ArrayList;

public class NewArrayIntArray {
    public NewArrayIntArray() {

    }

    @NativeObfuscation
    public int[][] getArray() {
        return new int[2][];
    }

    public ArrayList<int[]> test() {
        ArrayList<int[]> res = new ArrayList<>(2);
        int[][] native_array = this.getArray();
        for (int i = 0; i < native_array.length; i++) {
            res.add(native_array[i]);
        }
        return res;
    }

}
