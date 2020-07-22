package testclasses.mangling;

import it.oblive.annotations.NativeObfuscation;

public class Underscore_Class {
    public Underscore_Class() {

    }

    @NativeObfuscation
    public int add(int a, int b) {
        return a + b;
    }
}
