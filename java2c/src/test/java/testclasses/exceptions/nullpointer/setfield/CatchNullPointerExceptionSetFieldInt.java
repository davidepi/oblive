package testclasses.exceptions.nullpointer.setfield;

import eu.fbk.hardening.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassInt;

public class CatchNullPointerExceptionSetFieldInt {

    public CatchNullPointerExceptionSetFieldInt() {

    }

    @NativeObfuscation
    public int exec(SupportClassInt obj) {
        int res = 0;
        try {
            obj.a = 0;
            res += 1000;
        } catch (NullPointerException e) {
            res++;
        }

        try {
            obj.a = 0;
            res += 1000;
        } catch (RuntimeException e) {
            res++;
        }

        try {
            obj.a = 0;
            res += 1000;
        } catch (Exception e) {
            res++;
        }

        try {
            obj.a = 0;
            res += 1000;
        } catch (Throwable e) {
            res++;
        }

        return res;
    }
}
