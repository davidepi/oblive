package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotations.NativeObfuscation;

import java.util.ArrayList;

public class NewArrayChar {
    public NewArrayChar() {

    }

    @NativeObfuscation
    public char[] getArray() {
        return new char[10];
    }

    public ArrayList<Character> test() {
        ArrayList<Character> res = new ArrayList<Character>(10);
        char[] native_array = this.getArray();
        for (int i = 0; i < native_array.length; i++)
            res.add(native_array[i]);
        return res;
    }

}
