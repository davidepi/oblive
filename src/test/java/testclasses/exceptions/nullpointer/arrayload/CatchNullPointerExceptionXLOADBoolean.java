package testclasses.exceptions.nullpointer.arrayload;

import eu.fbk.hardening.annotation.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassBoolean;

public class CatchNullPointerExceptionXLOADBoolean {

    public CatchNullPointerExceptionXLOADBoolean() {

    }

    @NativeObfuscation
    public int exec(SupportClassBoolean obj) {
        int res = 0;
        try {
            res += obj.b[1] ? 1 : 0;
            res += 1000;
        } catch (NullPointerException e) {
            res++;
        }

        try {
            res += obj.b[1] ? 1 : 0;
            res += 1000;
        } catch (RuntimeException e) {
            res++;
        }

        try {
            res += obj.b[1] ? 1 : 0;
            res += 1000;
        } catch (Exception e) {
            res++;
        }

        try {
            res += obj.b[1] ? 1 : 0;
            res += 1000;
        } catch (Throwable e) {
            res++;
        }

        return res;
    }
}
