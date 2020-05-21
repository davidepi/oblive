package testclasses.antidebug;

import it.oblive.annotations.AntidebugTime;
import it.oblive.annotations.NativeObfuscation;

public class AntidebugTimeCheck {
    public AntidebugTimeCheck() {

    }

    @NativeObfuscation
    @AntidebugTime
    public static int add(int a, int b) {
        return a + b;
    }
}
