package testclasses.exceptions.nullpointer.getfield;

import eu.fbk.hardening.annotation.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassBoolean;

public class CatchNullPointerExceptionGetFieldBoolean {

    public CatchNullPointerExceptionGetFieldBoolean() {

    }

    @NativeObfuscation
    public int exec(SupportClassBoolean obj) {
        int res = 0;
        try {
            res += obj.a ? 1 : 0;
            res += 1000;
        } catch (NullPointerException e) {
            res++;
        }

        try {
            res += obj.a ? 1 : 0;
            res += 1000;
        } catch (RuntimeException e) {
            res++;
        }

        try {
            res += obj.a ? 1 : 0;
            res += 1000;
        } catch (Exception e) {
            res++;
        }

        try {
            res += obj.a ? 1 : 0;
            res += 1000;
        } catch (Throwable e) {
            res++;
        }

        return res;
    }
}
