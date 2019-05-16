package testclasses.exceptions.outofbounds.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowArrayLoadOutOfBoundsObject {
    private String[] array;

    public ThrowArrayLoadOutOfBoundsObject() {
        this.array = new String[2];
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public String exec() {
        return this.array[2];
    }
}
