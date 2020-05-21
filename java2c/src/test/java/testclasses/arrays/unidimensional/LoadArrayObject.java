package testclasses.arrays.unidimensional;

import it.oblive.annotations.NativeObfuscation;

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
