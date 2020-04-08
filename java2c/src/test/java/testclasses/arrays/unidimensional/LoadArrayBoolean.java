package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class LoadArrayBoolean {
    private boolean[] array;

    public LoadArrayBoolean() {
        this.array = new boolean[]{false, false, false, false, true, false, false, false, false, false};
    }

    @NativeObfuscation
    public boolean getVal() {
        return this.array[9];
    }

}
