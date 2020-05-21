package testclasses.exceptions.invoke.invokeinterface;

import it.oblive.annotations.NativeObfuscation;

public class CatchInvokeInterfaceFloat {
    public CatchInvokeInterfaceFloat() {

    }

    @NativeObfuscation
    public float div(DivisionInterface interf, float a) {
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
