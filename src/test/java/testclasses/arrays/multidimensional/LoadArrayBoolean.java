package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class LoadArrayBoolean {
    private boolean[][] array;

    public LoadArrayBoolean() {
        this.array = new boolean[2][3];
        this.array[0] = new boolean[]{true, false, true};
        this.array[1] = new boolean[]{false, true, false};
    }

    @NativeObfuscation
    public boolean getVal() {
        return this.array[1][1];
    }

}
