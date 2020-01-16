package testclasses.stack;


import eu.fbk.hardening.annotation.NativeObfuscation;

//BIPUSH
public class NullConst {
    public NullConst() {

    }

    @NativeObfuscation
    public Object exec() {
        return null;
    }
}
