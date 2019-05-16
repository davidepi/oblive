package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class SetStaticShort {
    private static short fieldS;

    public SetStaticShort() {
        SetStaticShort.fieldS = 3000;
        this.setStatic((short) -3000);
    }

    public short getStatic() {
        return SetStaticShort.fieldS;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public void setStatic(short value) {
        SetStaticShort.fieldS = value;
    }
}
