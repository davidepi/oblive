package testclasses.antidebug;

import eu.fbk.hardening.annotation.AntidebugSelf;
import eu.fbk.hardening.annotation.NativeObfuscation;

public class AntidebugSelfDebugging {
    public AntidebugSelfDebugging() {

    }

    @NativeObfuscation
    @AntidebugSelf
    public static int add(int a, int b) {
        return a + b;
    }
}
