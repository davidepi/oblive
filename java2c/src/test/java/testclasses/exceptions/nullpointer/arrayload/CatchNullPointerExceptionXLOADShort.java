package testclasses.exceptions.nullpointer.arrayload;

import eu.fbk.hardening.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassShort;

public class CatchNullPointerExceptionXLOADShort {

    public CatchNullPointerExceptionXLOADShort() {

    }

    @NativeObfuscation
    public int exec(SupportClassShort obj) {
        int res = 0;
        try {
            res += obj.b[1];
            res += 1000;
        } catch (NullPointerException e) {
            res++;
        }

        try {
            res += obj.b[1];
            res += 1000;
        } catch (RuntimeException e) {
            res++;
        }

        try {
            res += obj.b[1];
            res += 1000;
        } catch (Exception e) {
            res++;
        }

        try {
            res += obj.b[1];
            res += 1000;
        } catch (Throwable e) {
            res++;
        }

        return res;
    }
}
