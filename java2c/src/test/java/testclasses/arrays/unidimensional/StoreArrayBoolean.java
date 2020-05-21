package testclasses.arrays.unidimensional;

import it.oblive.annotations.NativeObfuscation;

import java.util.ArrayList;

public class StoreArrayBoolean {
    private boolean[] array;

    public StoreArrayBoolean() {
        this.array = new boolean[]{false, false, false, true, false, true, false, false, false, false};
    }

    @NativeObfuscation
    public void setVal(int i, boolean val) {
        this.array[i] = val;
    }

    public ArrayList<Boolean> test() {
        ArrayList<Boolean> retval = new ArrayList<>();
        int i = 4;
        this.setVal(i, true);
        //assert that also the rest of the array is unchanged
        for (int j = 0; j < this.array.length; j++)
            retval.add(array[j]);
        return retval;
    }

}
