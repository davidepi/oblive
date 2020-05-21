package testclasses.exceptions.invoke.invokeinterface;

import it.oblive.annotations.NativeObfuscation;

public class CatchInvokeInterfaceShort {
    public CatchInvokeInterfaceShort() {

    }

    @NativeObfuscation
    public int div(DivisionInterface interf, short a) {
        int res = 0;
        try {
            res += interf.div(a);
            res++;
        } catch (Exception e) {
            res += 1000;
        }
        return res;
    }
}
