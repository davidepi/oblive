package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

import java.util.ArrayList;

public class NewArrayObject {
    public NewArrayObject() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
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
