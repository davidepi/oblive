package testclasses.invoke.invokespecial;

import it.oblive.annotations.NativeObfuscation;

public class InvokeVirtualObject {
    @NativeObfuscation
    public String concatenate(String a, char b) {
        return normalcat(a, b);
    }

    public String normalcat(String a, char b) {
        return a + b;
    }
}
