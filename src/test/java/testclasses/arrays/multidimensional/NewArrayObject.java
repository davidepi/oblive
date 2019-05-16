package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

import java.util.ArrayList;

public class NewArrayObject {
    public NewArrayObject() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public String[][] getArray() {
        return new String[2][3];
    }

    public ArrayList<ArrayList<String>> test() {
        ArrayList<ArrayList<String>> res = new ArrayList<>(2);
        String[][] native_array = this.getArray();
        for (int i = 0; i < native_array.length; i++) {
            ArrayList<String> current = new ArrayList<>(3);
            res.add(current);

        }
        return res;
    }

}
