package testclasses.exceptions.invoke.invokespecial;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeVirtualLong {
    public InvokeVirtualLong() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public long add(long a, long b) {
        return normalAdd(a, b);
    }

    public long normalAdd(long a, long b) {
        int c = 1 / 0;
        return a + b;
    }
}