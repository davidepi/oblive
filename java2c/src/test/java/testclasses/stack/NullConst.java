package testclasses.stack;


import eu.fbk.hardening.annotations.NativeObfuscation;

//BIPUSH
public class NullConst {
    public NullConst() {

    }

    @NativeObfuscation
    public Object exec() {
        return null;
    }
}
