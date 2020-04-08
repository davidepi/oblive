package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotations.NativeObfuscation;

import java.util.ArrayList;

public class NewArrayBooleanThreeDims {
    public NewArrayBooleanThreeDims() {

    }

    @NativeObfuscation
    public boolean[][][] getArray() {
        return new boolean[2][3][4];
    }

    public ArrayList<ArrayList<ArrayList<Boolean>>> test() {
        ArrayList<ArrayList<ArrayList<Boolean>>> res = new ArrayList<>(2);
        boolean[][][] native_array = this.getArray();
        for (int i = 0; i < native_array.length; i++) {
            ArrayList<ArrayList<Boolean>> current = new ArrayList<>(3);
            for (int j = 0; j < native_array[i].length; j++) {
                current.add(new ArrayList<Boolean>(4));
            }
            res.add(current);
        }
        return res;
    }

}
