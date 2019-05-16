package testclasses.exceptions;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class RethrowException {
    public RethrowException() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec() {
        int res = 0;
        try {
            throw new ClassCastException();
        } catch (ClassCastException e) {
            throw new ClassCastException();
        }
    }
}
