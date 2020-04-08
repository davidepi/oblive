package testclasses.antidebug;

import eu.fbk.hardening.annotations.AntidebugTime;
import eu.fbk.hardening.annotations.NativeObfuscation;

public class AntidebugTimeCheck {
    public AntidebugTimeCheck() {

    }

    @NativeObfuscation
    @AntidebugTime
    public static int add(int a, int b) {
        return a + b;
    }
}
