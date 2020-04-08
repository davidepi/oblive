package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotations.NativeObfuscation;

import java.util.ArrayList;

public class NewArrayByteThreeDims {
    public NewArrayByteThreeDims() {

    }

    @NativeObfuscation
    public byte[][][] getArray() {
        return new byte[2][3][4];
    }

    public ArrayList<ArrayList<ArrayList<Byte>>> test() {
        ArrayList<ArrayList<ArrayList<Byte>>> res = new ArrayList<>(2);
        byte[][][] native_array = this.getArray();
        for (int i = 0; i < native_array.length; i++) {
            ArrayList<ArrayList<Byte>> current = new ArrayList<>(3);
            for (int j = 0; j < native_array[i].length; j++) {
                current.add(new ArrayList<Byte>(4));
            }
            res.add(current);
        }
        return res;
    }

}
