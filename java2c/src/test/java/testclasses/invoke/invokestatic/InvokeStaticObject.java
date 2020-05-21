package testclasses.invoke.invokestatic;

import it.oblive.annotations.NativeObfuscation;

public class InvokeStaticObject {
    public static String normalcat(String a, char b) {
        return a + b;
    }

    @NativeObfuscation
    public String concatenate(String a, char b) {
        return normalcat(a, b);
    }
}
