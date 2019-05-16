package testclasses.exceptions.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowInvokeStaticByte {
    public ThrowInvokeStaticByte() {

    }

    public static byte normalDiv(int a, int b) {
        return (byte) (a / b);
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int div(int a) {
        return normalDiv(a, 0);
    }
}
