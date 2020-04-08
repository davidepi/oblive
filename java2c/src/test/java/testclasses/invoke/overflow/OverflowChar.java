package testclasses.invoke.overflow;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class OverflowChar {
    char a;
    char b;
    char c;

    public OverflowChar() {
        a = Character.MAX_VALUE;
        b = 1;
        c = (char) (a + b);
    }

    @NativeObfuscation
    public boolean add(char a, char b) {
        this.b = this.c;
        char r0 = normalAdd(a, b);
        char r1 = (char) (a + b);
        return r0 == r1 && r1 == this.c;
    }

    public char normalAdd(char a, char b) {
        return (char) (a + b);
    }
}