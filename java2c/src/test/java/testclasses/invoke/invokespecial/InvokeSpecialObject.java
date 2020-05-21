package testclasses.invoke.invokespecial;

import it.oblive.annotations.NativeObfuscation;

public class InvokeSpecialObject extends InvokeVirtualObject {
    public InvokeSpecialObject() {

    }

    @NativeObfuscation
    @Override
    public String concatenate(String a, char b) {
        return super.normalcat(a, b);
    }

    //wrong method, I want the one of the superclass to be called -> invokespecial
    public String normalcat(String a, char b) {
        return "WRONG INVOKESPECIAL!";
    }
}