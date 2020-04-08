package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class LoadArrayObject {
    private String[] array;

    public LoadArrayObject() {
        this.array = new String[]{"hello", "world"};
    }

    @NativeObfuscation
    public String getVal() {
        return this.array[1];
    }

}
