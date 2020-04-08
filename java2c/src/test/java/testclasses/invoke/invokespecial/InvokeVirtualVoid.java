package testclasses.invoke.invokespecial;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class InvokeVirtualVoid {
    public InvokeVirtualVoid() {

    }

    @NativeObfuscation
    public void add(int a, int b) {
        print(a, b);
    }

    public void print(int a, int b) {
        System.out.println(a + b);
    }
}