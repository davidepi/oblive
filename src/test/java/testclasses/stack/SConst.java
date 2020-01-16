package testclasses.stack;


import eu.fbk.hardening.annotation.NativeObfuscation;

//SIPUSH
public class SConst {
    public SConst() {

    }

    @NativeObfuscation
    public int exec() {
        short a = -3000;
        short b = 12000;
        return a + b;
    }
}
