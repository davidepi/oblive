package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotations.NativeObfuscation;

import java.util.ArrayList;

public class StoreArrayObject {
    private String[][] array;

    public StoreArrayObject() {
        this.array = new String[2][3];
        this.array[0] = new String[]{"void", "void", "void"};
        this.array[1] = new String[]{"無効", "無効", "無効"};
    }

    @NativeObfuscation
    public void setVal(int i, int j, String val) {
        this.array[i][j] = val;
    }

    public ArrayList<ArrayList<String>> test() {
        ArrayList<ArrayList<String>> retval = new ArrayList<>();
        int k = 1;
        int l = 2;
        this.setVal(k, l, "ok!");
        //assert that also the rest of the array is unchanged
        String[][] native_array = array;
        for (int i = 0; i < native_array.length; i++) {
            ArrayList<String> current = new ArrayList<>(3);
            retval.add(current);

        }
        return retval;
    }

}
