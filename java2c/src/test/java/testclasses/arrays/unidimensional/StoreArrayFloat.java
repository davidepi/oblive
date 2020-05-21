package testclasses.arrays.unidimensional;

import it.oblive.annotations.NativeObfuscation;

import java.util.ArrayList;

public class StoreArrayFloat {
    private float[] array;

    public StoreArrayFloat() {
        this.array = new float[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    }

    @NativeObfuscation
    public void setVal(int i, float val) {
        this.array[i] = val;
    }

    public ArrayList<Float> test() {
        ArrayList<Float> retval = new ArrayList<>();
        int i = 4;
        this.setVal(i, 10.52f);
        //assert that also the rest of the array is unchanged
        for (int j = 0; j < this.array.length; j++)
            retval.add(array[j]);
        return retval;
    }

}
