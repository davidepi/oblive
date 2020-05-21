package testclasses.fields;

import it.oblive.annotations.NativeObfuscation;

public class GetFieldByte {
    private byte fieldB;

    public GetFieldByte() {
        this.fieldB = 100;
    }

    @NativeObfuscation
    public byte getField() {
        return this.fieldB;
    }
}
