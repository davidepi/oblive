package testclasses;

import eu.fbk.hardening.annotation.NativeObfuscation;
import testclasses.arithmetic.IAdd;

public class AnonymousInnerClass {
    public AnonymousInnerClass() {

    }

    public static int add(int a, int b) {
        IAdd cls = new IAdd() {
            @NativeObfuscation
            public int exec(int a, int b) {
                return a + a + b + b;
            }
        };
        return cls.exec(a, b);
    }
}
