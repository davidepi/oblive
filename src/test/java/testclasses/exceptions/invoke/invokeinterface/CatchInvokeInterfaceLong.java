package testclasses.exceptions.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class CatchInvokeInterfaceLong {
    public CatchInvokeInterfaceLong() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public long div(DivisionInterface interf, long a) {
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
