package testclasses.exceptions.invoke.invokespecial;

import it.oblive.annotations.NativeObfuscation;

public class InvokeVirtualObject {
    @NativeObfuscation
    public String concatenate(String a, char b) {
        return normalcat(a, b);
    }

    public String normalcat(String a, char b) {
        int c = 1 / 0;
        return a + b;
    }
}
