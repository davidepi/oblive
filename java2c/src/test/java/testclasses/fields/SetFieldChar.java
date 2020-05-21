package testclasses.fields;

import it.oblive.annotations.NativeObfuscation;

public class SetFieldChar {
    private char fieldC;

    public SetFieldChar() {
        this.fieldC = 'z';
        this.setField('a');
    }

    public char getField() {
        return this.fieldC;
    }

    @NativeObfuscation
    public void setField(char value) {
        this.fieldC = value;
    }
}
