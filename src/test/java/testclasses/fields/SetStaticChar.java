package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class SetStaticChar {
    private static char fieldC;

    public SetStaticChar() {
        SetStaticChar.fieldC = 'z';
        this.setStatic('a');
    }

    public char getStatic() {
        return SetStaticChar.fieldC;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public void setStatic(char value) {
        SetStaticChar.fieldC = value;
    }
}
