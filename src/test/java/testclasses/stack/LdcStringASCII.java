package testclasses.stack;


import eu.fbk.hardening.annotation.NativeObfuscation;

public class LdcStringASCII {
    public LdcStringASCII() {

    }

    @NativeObfuscation
    public String exec() {
        return "hello";
    }
}
