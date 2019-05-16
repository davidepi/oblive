package testclasses.invoke.invokevirtual;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeVirtualVoid {
    public InvokeVirtualVoid() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public void add(int a, int b) {
        print(a, b);
    }

    public void print(int a, int b) {
        System.out.println(a + b);
    }
}