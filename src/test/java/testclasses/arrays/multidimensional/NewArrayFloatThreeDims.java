package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

import java.util.ArrayList;

public class NewArrayFloatThreeDims {
    public NewArrayFloatThreeDims() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public float[][][] getArray() {
        return new float[2][3][4];
    }

    public ArrayList<ArrayList<ArrayList<Float>>> test() {
        ArrayList<ArrayList<ArrayList<Float>>> res = new ArrayList<>(2);
        float[][][] native_array = this.getArray();
        for (int i = 0; i < native_array.length; i++) {
            ArrayList<ArrayList<Float>> current = new ArrayList<>(3);
            for (int j = 0; j < native_array[i].length; j++) {
                current.add(new ArrayList<Float>(4));
            }
            res.add(current);
        }
        return res;
    }

}
