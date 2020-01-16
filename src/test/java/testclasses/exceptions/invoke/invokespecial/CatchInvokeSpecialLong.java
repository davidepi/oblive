package testclasses.exceptions.invoke.invokespecial;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class CatchInvokeSpecialLong extends InvokeVirtualLong {
    public CatchInvokeSpecialLong() {

    }

    @NativeObfuscation
    @Override
    public long add(long a, long b) {
        int res = 0;
        try {
            super.normalAdd(a, b);
            res += 1000;
        } catch (Exception e) {
            res++;
        }
        return (long) res;
    }

    //wrong method, I want the one of the superclass to be called -> invokespecial
    public long normalAdd(long a, long b) {
        return a - b;
    }
}
