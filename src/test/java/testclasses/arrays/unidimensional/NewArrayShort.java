package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

import java.util.ArrayList;

public class NewArrayShort {
    public NewArrayShort() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public short[] getArray() {
        return new short[10];
    }

    public ArrayList<Short> test() {
        ArrayList<Short> res = new ArrayList<Short>(10);
        short[] native_array = this.getArray();
        for (int i = 0; i < native_array.length; i++)
            res.add(native_array[i]);
        return res;
    }

}
