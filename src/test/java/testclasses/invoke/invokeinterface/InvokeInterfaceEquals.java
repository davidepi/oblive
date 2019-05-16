package testclasses.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

import java.util.HashMap;
import java.util.Map;

public class InvokeInterfaceEquals {
    public Map<Integer, String> map0;

    public InvokeInterfaceEquals() {
        map0 = new HashMap<>();
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    @Override
    public boolean equals(Object obj) {
        InvokeInterfaceEquals that = (InvokeInterfaceEquals) obj;
//        if(this.map0.equals(that.map0))
//            return true;
//        else
//            return false;
        return true;
    }
}