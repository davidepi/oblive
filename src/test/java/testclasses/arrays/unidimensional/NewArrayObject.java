package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotation.NativeObfuscation;

import java.util.ArrayList;

public class NewArrayObject {
    public NewArrayObject() {

    }

    @NativeObfuscation
    public String[] getArray() {
        return new String[2];
    }

    public ArrayList<String> test() {
        ArrayList<String> res = new ArrayList<String>(10);
        String[] native_array = this.getArray();
        for (int i = 0; i < native_array.length; i++)
            res.add(native_array[i]);
        return res;
    }

}
