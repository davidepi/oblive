package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class SetFieldChar {
    private char fieldC;

    public SetFieldChar() {
        this.fieldC = 'z';
        this.setField('a');
    }

    public char getField() {
        return this.fieldC;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public void setField(char value) {
        this.fieldC = value;
    }
}
