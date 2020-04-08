package testclasses.invoke.invokespecial;

import eu.fbk.hardening.annotations.NativeObfuscation;

import java.util.ArrayList;

public class InvokeSpecialIntArray extends InvokeVirtualIntArray {
    public InvokeSpecialIntArray() {

    }

    @NativeObfuscation
    @Override
    public int[] exec() {
        return super.returnArray();
    }

    public int[] returnArray() {
        return new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    }

    public ArrayList<Integer> test() {
        ArrayList<Integer> res = new ArrayList<Integer>(10);
        int[] native_array = this.exec();
        for (int i = 0; i < native_array.length; i++)
            res.add(native_array[i]);
        return res;
    }
}