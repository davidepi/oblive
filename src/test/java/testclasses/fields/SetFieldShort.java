package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class SetFieldShort {
    private short fieldS;

    public SetFieldShort() {
        this.fieldS = 3000;
        this.setField((short) -3000);
    }

    public short getField() {
        return this.fieldS;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public void setField(short value) {
        this.fieldS = value;
    }
}
