package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotations.NativeObfuscation;

import java.util.ArrayList;

public class NewArrayInt {
    public NewArrayInt() {

    }

    @NativeObfuscation
    public int[] getArray() {
        return new int[10];
    }

    public ArrayList<Integer> test() {
        ArrayList<Integer> res = new ArrayList<Integer>(10);
        int[] native_array = this.getArray();
        for (int i = 0; i < native_array.length; i++)
            res.add(native_array[i]);
        return res;
    }

}
