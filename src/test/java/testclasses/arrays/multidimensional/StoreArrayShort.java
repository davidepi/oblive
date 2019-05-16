package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

import java.util.ArrayList;

public class StoreArrayShort {
    private short[][] array;

    public StoreArrayShort() {
        this.array = new short[2][10];
        this.array[0] = new short[]{1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000};
        this.array[1] = new short[]{1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000};
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public void setVal(int i, int j, short val) {
        this.array[i][j] = val;
    }

    public ArrayList<ArrayList<Short>> test() {
        ArrayList<ArrayList<Short>> retval = new ArrayList<>();
        int k = 1;
        int l = 4;
        this.setVal(k, l, (short) 2000);
        //assert that also the rest of the array is unchanged
        short[][] native_array = array;
        for (int i = 0; i < native_array.length; i++) {
            ArrayList<Short> current = new ArrayList<>(3);
            retval.add(current);

        }
        return retval;
    }

}
