package testclasses.invoke.invokestatic;

import it.oblive.annotations.NativeObfuscation;

public class InvokeStaticInt {
    public InvokeStaticInt() {

    }

    public static int normalAdd(int a, int b) {
        return a + b;
    }

    @NativeObfuscation
    public int add(int a, int b) {
        return testclasses.invoke.invokestatic.InvokeStaticInt.normalAdd(a, b);
    }
}