package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class LoadArrayObject {
    private String[][] array;

    public LoadArrayObject() {
        this.array = new String[3][2];
        this.array[0] = new String[]{"hello", "world"};
        this.array[1] = new String[]{"ciao", "mondo"};
        this.array[2] = new String[]{"こんにちは", "世界"};
    }

    @NativeObfuscation
    public String getVal() {
        return this.array[2][0];
    }

}
