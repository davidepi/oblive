package testclasses.stack;


import eu.fbk.hardening.annotations.NativeObfuscation;

public class LdcStringASCII {
    public LdcStringASCII() {

    }

    @NativeObfuscation
    public String exec() {
        return "hello";
    }
}
