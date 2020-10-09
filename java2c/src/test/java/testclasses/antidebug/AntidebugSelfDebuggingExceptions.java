package testclasses.antidebug;

import it.oblive.annotations.AntidebugSelf;
import it.oblive.annotations.NativeObfuscation;

public class AntidebugSelfDebuggingExceptions {
    public AntidebugSelfDebuggingExceptions() {

    }

    @NativeObfuscation
    @AntidebugSelf
    public static String name(String oname) {
        if (oname == null) {
            throw new IllegalArgumentException("oname cannot be null");
        }

        return "placeholder";
    }
}
