package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

import java.util.ArrayList;

public class SetFieldIntArray {
    private int[] array;
    private int[] array2;

    public SetFieldIntArray() {
        this.array2 = new int[]{1, 2, 3, 4, 6, 5, 7, 8, 9, 0};
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public void setArray() {
        this.array = array2;
    }

    public ArrayList<Integer> test() {
        ArrayList<Integer> res = new ArrayList<Integer>(10);
        this.setArray();
        int[] native_array = this.array;
        for (int i = 0; i < native_array.length; i++)
            res.add(native_array[i]);
        return res;
    }

}
