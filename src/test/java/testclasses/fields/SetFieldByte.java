package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class SetFieldByte {
    private byte fieldB;

    public SetFieldByte() {
        this.fieldB = 100;
        this.setField((byte) -100);
    }

    public byte getField() {
        return this.fieldB;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public void setField(byte value) {
        this.fieldB = value;
    }
}
