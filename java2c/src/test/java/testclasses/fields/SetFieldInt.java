package testclasses.fields;

import it.oblive.annotations.NativeObfuscation;

public class SetFieldInt {
    private int fieldI;

    public SetFieldInt() {
        this.fieldI = 1000000;
        this.setField(-1000000);
    }

    public int getField() {
        return this.fieldI;
    }

    @NativeObfuscation
    public void setField(int value) {
        this.fieldI = value;
    }
}
