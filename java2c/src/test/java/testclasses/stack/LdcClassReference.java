package testclasses.stack;


import it.oblive.annotations.NativeObfuscation;

public class LdcClassReference {
    public LdcClassReference() {

    }

    @NativeObfuscation
    public Class exec() {
        return java.lang.String.class;
    }
}
