package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotation.NativeObfuscation;

import java.util.ArrayList;

public class NewArrayByte {
    public NewArrayByte() {

    }

    @NativeObfuscation
    public byte[][] getArray() {
        return new byte[2][3];
    }

    public ArrayList<ArrayList<Byte>> test() {
        ArrayList<ArrayList<Byte>> res = new ArrayList<>(2);
        byte[][] native_array = this.getArray();
        for (int i = 0; i < native_array.length; i++) {
            ArrayList<Byte> current = new ArrayList<>(3);
            res.add(current);
        }
        return res;
    }

}
