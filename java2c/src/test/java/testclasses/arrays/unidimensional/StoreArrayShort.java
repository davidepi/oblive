package testclasses.arrays.unidimensional;

import it.oblive.annotations.NativeObfuscation;

import java.util.ArrayList;

public class StoreArrayShort {
    private short[] array;

    public StoreArrayShort() {
        this.array = new short[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    }

    @NativeObfuscation
    public void setVal(int i, short val) {
        this.array[i] = val;
    }

    public ArrayList<Short> test() {
        ArrayList<Short> retval = new ArrayList<>();
        int i = 4;
        this.setVal(i, (short) 3000);
        //assert that also the rest of the array is unchanged
        for (int j = 0; j < this.array.length; j++)
            retval.add(array[j]);
        return retval;
    }

}
