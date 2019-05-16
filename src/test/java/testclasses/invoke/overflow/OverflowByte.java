package testclasses.invoke.overflow;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class OverflowByte {
    byte a = Byte.MAX_VALUE;
    byte b = 1;
    byte c;

    public OverflowByte() {
        c = (byte) (a + b);
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public boolean add(byte a, byte b) {
        this.b = this.c;
        byte r0 = normalAdd(a, b);
        byte r1 = (byte) (a + b);
        System.out.println(r0);
        System.out.println(r1);
        return r0 == r1 && r1 == this.c;
    }

    public byte normalAdd(byte a, byte b) {
        return (byte) (a + b);
    }
}