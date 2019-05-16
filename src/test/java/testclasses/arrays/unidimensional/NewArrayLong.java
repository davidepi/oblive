package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

import java.util.ArrayList;

public class NewArrayLong {
    public NewArrayLong() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public long[] getArray() {
        return new long[10];
    }

    public ArrayList<Long> test() {
        ArrayList<Long> res = new ArrayList<Long>(10);
        long[] native_array = this.getArray();
        for (int i = 0; i < native_array.length; i++)
            res.add(native_array[i]);
        return res;
    }

}
