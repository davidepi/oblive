package testclasses.antidebug;

import it.oblive.annotations.AntidebugSelf;
import it.oblive.annotations.NativeObfuscation;

public class AntidebugSelfDebuggingMulticall {
    public AntidebugSelfDebuggingMulticall() {

    }


    public static int doubleAdd(int a, int b) {
        return nativeAdd(a, b) + nativeAdd(a, b);
    }

    @AntidebugSelf
    @NativeObfuscation
    public static int nativeAdd(int a, int b) {
        return a + b;
    }
}
