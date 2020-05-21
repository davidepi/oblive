package testclasses.invoke.invokevirtual;

import it.oblive.annotations.NativeObfuscation;

public class InvokeVirtualNoInput {
    public InvokeVirtualNoInput() {

    }

    @NativeObfuscation
    public boolean add(int a, int b) {
        return alwaysTrue();
    }

    public boolean alwaysTrue() {
        return true;
    }
}