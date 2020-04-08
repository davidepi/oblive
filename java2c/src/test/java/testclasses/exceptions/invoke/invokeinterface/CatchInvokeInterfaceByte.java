package testclasses.exceptions.invoke.invokeinterface;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class CatchInvokeInterfaceByte {
    public CatchInvokeInterfaceByte() {

    }

    @NativeObfuscation
    public int div(DivisionInterface interf, byte a) {
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
