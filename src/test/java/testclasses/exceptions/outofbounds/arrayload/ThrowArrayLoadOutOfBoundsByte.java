package testclasses.exceptions.outofbounds.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowArrayLoadOutOfBoundsByte {
    private byte[] array;

    public ThrowArrayLoadOutOfBoundsByte() {
        this.array = new byte[2];
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public byte exec() {
        return this.array[2];
    }
}
