package testclasses.antidebug;

import eu.fbk.hardening.annotations.AntidebugSelf;
import eu.fbk.hardening.annotations.NativeObfuscation;

public class AntidebugSelfDebugging {
    public AntidebugSelfDebugging() {

    }

    @NativeObfuscation
    @AntidebugSelf
    public static int add(int a, int b) {
        return a + b;
    }
}
