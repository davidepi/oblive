package testclasses.invoke.invokeinterface;

import it.oblive.annotations.NativeObfuscation;

import java.util.HashMap;
import java.util.Map;

public class InvokeInterfaceEquals {
    public Map<Integer, String> map0;

    public InvokeInterfaceEquals() {
        map0 = new HashMap<>();
    }

    @NativeObfuscation
    @Override
    public boolean equals(Object obj) {
        InvokeInterfaceEquals that = (InvokeInterfaceEquals) obj;
        return true;
    }
}