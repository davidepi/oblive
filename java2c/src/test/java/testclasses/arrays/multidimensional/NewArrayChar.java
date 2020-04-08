package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotations.NativeObfuscation;

import java.util.ArrayList;

public class NewArrayChar {
    public NewArrayChar() {

    }

    @NativeObfuscation
    public char[][] getArray() {
        return new char[2][3];
    }

    public ArrayList<ArrayList<Character>> test() {
        ArrayList<ArrayList<Character>> res = new ArrayList<>(2);
        char[][] native_array = this.getArray();
        for (int i = 0; i < native_array.length; i++) {
            ArrayList<Character> current = new ArrayList<>(3);
            res.add(current);
        }
        return res;
    }

}
