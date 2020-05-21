package testclasses.arrays.unidimensional;

import it.oblive.annotations.NativeObfuscation;

import java.util.ArrayList;

public class NewArrayByte {
    public NewArrayByte() {

    }

    @NativeObfuscation
    public byte[] getArray() {
        return new byte[10];
    }

    public ArrayList<Byte> test() {
        ArrayList<Byte> res = new ArrayList<Byte>(10);
        byte[] native_array = this.getArray();
        for (int i = 0; i < native_array.length; i++)
            res.add(native_array[i]);
        return res;
    }

}
