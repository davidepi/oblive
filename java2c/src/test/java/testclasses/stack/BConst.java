package testclasses.stack;


import eu.fbk.hardening.annotations.NativeObfuscation;

//BIPUSH
public class BConst {
    public BConst() {

    }

    @NativeObfuscation
    public int exec() {
        byte a = -30;
        byte b = 120;
        return a + b;
    }
}
