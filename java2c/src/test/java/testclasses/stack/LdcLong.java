package testclasses.stack;


import eu.fbk.hardening.annotations.NativeObfuscation;

public class LdcLong {
    public LdcLong() {

    }

    @NativeObfuscation
    public long exec() {
        long a = 1000000000000L;
        long b = -1000000000001L;
        return a + b;
    }
}
