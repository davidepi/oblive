package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class LoadArrayBoolean {
    private boolean[][] array;

    public LoadArrayBoolean() {
        this.array = new boolean[2][3];
        this.array[0] = new boolean[]{true, false, true};
        this.array[1] = new boolean[]{false, true, false};
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public boolean getVal() {
        return this.array[1][1];
    }

}
