package testclasses.antidebug;

import it.oblive.annotations.AntidebugSelf;
import it.oblive.annotations.NativeObfuscation;

public class AntidebugSelfDebugging {
    public AntidebugSelfDebugging() {

    }

    @NativeObfuscation
    @AntidebugSelf
    public static int add(int a, int b) {
        return a + b;
    }
}
