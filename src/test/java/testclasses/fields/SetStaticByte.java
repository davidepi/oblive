package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class SetStaticByte {
    private static byte fieldB;

    public SetStaticByte() {
        SetStaticByte.fieldB = 100;
        this.setStatic((byte) -100);
    }

    public byte getStatic() {
        return SetStaticByte.fieldB;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public void setStatic(byte value) {
        SetStaticByte.fieldB = value;
    }
}
