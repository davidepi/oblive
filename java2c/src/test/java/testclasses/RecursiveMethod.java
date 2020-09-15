package testclasses;

import it.oblive.annotations.NativeObfuscation;

public class RecursiveMethod {
    public RecursiveMethod() {

    }

    @NativeObfuscation
    public static long factorial(int a) {
        if (a == 0) {
            return 1;
        } else {
            return a * factorial(a - 1);
        }
    }
}
