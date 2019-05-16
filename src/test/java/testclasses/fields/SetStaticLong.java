package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class SetStaticLong {
    private static long fieldJ;

    public SetStaticLong() {
        SetStaticLong.fieldJ = 10000000000L;
        this.setStatic(-50000000000L);
    }

    public long getStatic() {
        return SetStaticLong.fieldJ;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public void setStatic(long value) {
        SetStaticLong.fieldJ = value;
    }
}
