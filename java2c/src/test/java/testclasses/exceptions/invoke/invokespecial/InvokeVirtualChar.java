package testclasses.exceptions.invoke.invokespecial;

import it.oblive.annotations.NativeObfuscation;

public class InvokeVirtualChar {
    public InvokeVirtualChar() {

    }

    @NativeObfuscation
    public char add(char a, char b) {
        return normalAdd(a, b);
    }

    public char normalAdd(char a, char b) {
        int c = 1 / 0;
        return (char) (a + b);
    }
}