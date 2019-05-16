package testclasses.exceptions.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class CatchInvokeInterfaceBoolean {
    public CatchInvokeInterfaceBoolean() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int div(DivisionInterface interf, boolean a) {
        int res = 0;
        try {
            res += interf.div(a) ? 1 : 0;
            res++;
        } catch (Exception e) {
            res += 1000;
        }
        return res;
    }
}
