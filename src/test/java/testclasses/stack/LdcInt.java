package testclasses.stack;


import eu.fbk.hardening.annotation.NativeObfuscation;

public class LdcInt {
    public LdcInt() {

    }

    @NativeObfuscation
    public int exec() {
        int a = 1000000000;
        int b = -1000000001;
        return a + b;
    }
}
