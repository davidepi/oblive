package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

import java.util.ArrayList;

public class NewArrayFloat {
    public NewArrayFloat() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public float[][] getArray() {
        return new float[2][3];
    }

    public ArrayList<ArrayList<Float>> test() {
        ArrayList<ArrayList<Float>> res = new ArrayList<>(2);
        float[][] native_array = this.getArray();
        for (int i = 0; i < native_array.length; i++) {
            ArrayList<Float> current = new ArrayList<>(3);
            res.add(current);

        }
        return res;
    }

}
