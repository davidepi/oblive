package testclasses.invoke.invokestatic;

import it.oblive.annotations.NativeObfuscation;

public class InvokeStaticVoid {
    public InvokeStaticVoid() {

    }

    public static void print(int a, int b) {
        System.out.println(a + b);
    }

    @NativeObfuscation
    public void add(int a, int b) {
        print(a, b);
    }
}