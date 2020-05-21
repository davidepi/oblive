package testclasses.exceptions.invoke.invokeinterface;

import it.oblive.annotations.NativeObfuscation;

public class CatchInvokeInterfaceObject {
    public CatchInvokeInterfaceObject() {

    }

    @NativeObfuscation
    public int concatenate(DivisionInterface interf, String a) {
        int res = 0;
        try {
            res += interf.div(a).length();
            res++;
        } catch (Exception e) {
            res += 1000;
        }
        return res;
    }
}
