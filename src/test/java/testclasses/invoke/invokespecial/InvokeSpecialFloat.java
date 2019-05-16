package testclasses.invoke.invokespecial;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeSpecialFloat extends InvokeVirtualFloat {
    public InvokeSpecialFloat() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    @Override
    public float add(float a, float b) {
        return super.normalAdd(a, b);
    }

    //wrong method, I want the one of the superclass to be called -> invokespecial
    public float normalAdd(float a, float b) {
        return (a - b);
    }
}