package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotations.NativeObfuscation;

import java.util.ArrayList;

public class NewArrayShort {
    public NewArrayShort() {

    }

    @NativeObfuscation
    public short[][] getArray() {
        return new short[2][3];
    }

    public ArrayList<ArrayList<Short>> test() {
        ArrayList<ArrayList<Short>> res = new ArrayList<>(2);
        short[][] native_array = this.getArray();
        for (int i = 0; i < native_array.length; i++) {
            ArrayList<Short> current = new ArrayList<>(3);
            res.add(current);

        }
        return res;
    }

}
