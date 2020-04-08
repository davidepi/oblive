package testclasses.fields;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class SetStaticByte {
    private static byte fieldB;

    public SetStaticByte() {
        SetStaticByte.fieldB = 100;
        this.setStatic((byte) -100);
    }

    public byte getStatic() {
        return SetStaticByte.fieldB;
    }

    @NativeObfuscation
    public void setStatic(byte value) {
        SetStaticByte.fieldB = value;
    }
}
