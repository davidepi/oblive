package testclasses.antidebug;

import it.oblive.annotations.AntidebugSelf;
import it.oblive.annotations.NativeObfuscation;

public class AntidebugSelfDebuggingRecursive {
    public AntidebugSelfDebuggingRecursive() {

    }

    @NativeObfuscation
    @AntidebugSelf
    public static long factorial(int a) {
        if (a == 0) {
            return 1;
        } else {
            return a * factorial(a - 1);
        }
    }
}
