package testclasses.antidebug;

import eu.fbk.hardening.annotation.AntidebugTime;
import eu.fbk.hardening.annotation.NativeObfuscation;

public class AntidebugTimeCheck {
    public AntidebugTimeCheck() {

    }

    @NativeObfuscation
    @AntidebugTime
    public static int add(int a, int b) {
        return a + b;
    }
}
