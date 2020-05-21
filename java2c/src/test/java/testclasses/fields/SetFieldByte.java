package testclasses.fields;

import it.oblive.annotations.NativeObfuscation;

public class SetFieldByte {
    private byte fieldB;

    public SetFieldByte() {
        this.fieldB = 100;
        this.setField((byte) -100);
    }

    public byte getField() {
        return this.fieldB;
    }

    @NativeObfuscation
    public void setField(byte value) {
        this.fieldB = value;
    }
}
