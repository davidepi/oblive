package testclasses.exceptions.invoke.invokespecial;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class CatchInvokeSpecialDouble extends InvokeVirtualDouble {
    public CatchInvokeSpecialDouble() {

    }

    @NativeObfuscation
    @Override
    public double add(double a, double b) {
        int res = 0;
        try {
            super.normalAdd(a, b);
            res += 1000;
        } catch (Exception e) {
            res++;
        }
        return res;
    }

    //wrong method, I want the one of the superclass to be called -> invokespecial
    public double normalAdd(double a, double b) {
        return (a - b);
    }
}
