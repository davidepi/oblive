package testclasses.invoke.invokespecial;

import eu.fbk.hardening.annotations.NativeObfuscation;

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
}