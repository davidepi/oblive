package testclasses.exceptions;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowUserDefinedException {
    public ThrowUserDefinedException() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec() throws UserDefinedException {
        throw new UserDefinedException();
    }
}
