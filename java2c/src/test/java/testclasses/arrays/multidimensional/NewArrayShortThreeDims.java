package testclasses.arrays.multidimensional;

import it.oblive.annotations.NativeObfuscation;

import java.util.ArrayList;

public class NewArrayShortThreeDims {
    public NewArrayShortThreeDims() {

    }

    @NativeObfuscation
    public short[][][] getArray() {
        return new short[2][3][4];
    }

    public ArrayList<ArrayList<ArrayList<Short>>> test() {
        ArrayList<ArrayList<ArrayList<Short>>> res = new ArrayList<>(2);
        short[][][] native_array = this.getArray();
        for (int i = 0; i < native_array.length; i++) {
            ArrayList<ArrayList<Short>> current = new ArrayList<>(3);
            for (int j = 0; j < native_array[i].length; j++) {
                current.add(new ArrayList<Short>(4));
            }
            res.add(current);
        }
        return res;
    }

}
