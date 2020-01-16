package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotation.NativeObfuscation;

import java.util.ArrayList;

public class NewArrayDouble {
    public NewArrayDouble() {

    }

    @NativeObfuscation
    public float[][] getArray() {
        return new float[2][3];
    }

    public ArrayList<ArrayList<Double>> test() {
        ArrayList<ArrayList<Double>> res = new ArrayList<>(2);
        float[][] native_array = this.getArray();
        for (int i = 0; i < native_array.length; i++) {
            ArrayList<Double> current = new ArrayList<>(3);
            res.add(current);

        }
        return res;
    }

}
