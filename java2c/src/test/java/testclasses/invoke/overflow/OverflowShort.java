package testclasses.invoke.overflow;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class OverflowShort {
    short a;
    short b;
    short c;

    public OverflowShort() {
        a = Short.MAX_VALUE;
        b = 1;
        c = (short) (a + b);
    }

    @NativeObfuscation
    public boolean add(short a, short b) {
        this.b = this.c;
        short r0 = normalAdd(a, b);
        short r1 = (short) (a + b);
        return r0 == r1 && r1 == this.c;
    }

    public short normalAdd(short a, short b) {
        return (short) (a + b);
    }
}