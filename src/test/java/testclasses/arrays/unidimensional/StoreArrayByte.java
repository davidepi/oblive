package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotation.NativeObfuscation;

import java.util.ArrayList;

public class StoreArrayByte {
    private byte[] array;

    public StoreArrayByte() {
        this.array = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    }

    @NativeObfuscation
    public void setVal(int i, byte val) {
        this.array[i] = val;
    }

    public ArrayList<Byte> test() {
        ArrayList<Byte> retval = new ArrayList<>();
        int i = 4;
        this.setVal(i, (byte) 100);
        //assert that also the rest of the array is unchanged
        for (int j = 0; j < this.array.length; j++)
            retval.add(array[j]);
        return retval;
    }

}
