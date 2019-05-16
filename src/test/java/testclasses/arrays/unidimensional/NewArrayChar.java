package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

import java.util.ArrayList;

public class NewArrayChar {
    public NewArrayChar() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
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
