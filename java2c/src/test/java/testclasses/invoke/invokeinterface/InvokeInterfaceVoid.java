package testclasses.invoke.invokeinterface;

import it.oblive.annotations.NativeObfuscation;

public class InvokeInterfaceVoid {
    public InvokeInterfaceVoid() {

    }

    @NativeObfuscation
    public void print(AdderInterface interf, int a, int b) {
        interf.print(a, b);
    }
}