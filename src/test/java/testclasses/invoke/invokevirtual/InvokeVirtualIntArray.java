package testclasses.invoke.invokevirtual;

import eu.fbk.hardening.annotation.NativeObfuscation;

import java.util.ArrayList;

public class InvokeVirtualIntArray {
    public InvokeVirtualIntArray() {

    }

    @NativeObfuscation
    public int[] exec() {
        return returnArray();
    }

    public int[] returnArray() {
        return new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    }

    public ArrayList<Integer> test() {
        ArrayList<Integer> res = new ArrayList<Integer>(10);
        int[] native_array = this.exec();
        for (int i = 0; i < native_array.length; i++)
            res.add(native_array[i]);
        return res;
    }
}