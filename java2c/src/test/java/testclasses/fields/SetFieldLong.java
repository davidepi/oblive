package testclasses.fields;

import it.oblive.annotations.NativeObfuscation;

public class SetFieldLong {
    private long fieldJ;

    public SetFieldLong() {
        this.fieldJ = 10000000000L;
        this.setField(-50000000000L);
    }

    public long getField() {
        return this.fieldJ;
    }

    @NativeObfuscation
    public void setField(long value) {
        this.fieldJ = value;
    }
}
