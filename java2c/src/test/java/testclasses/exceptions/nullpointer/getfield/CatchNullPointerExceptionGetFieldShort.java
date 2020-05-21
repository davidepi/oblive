package testclasses.exceptions.nullpointer.getfield;

import it.oblive.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassShort;

public class CatchNullPointerExceptionGetFieldShort {

    public CatchNullPointerExceptionGetFieldShort() {

    }

    @NativeObfuscation
    public int exec(SupportClassShort obj) {
        int res = 0;
        try {
            res += obj.a;
            res += 1000;
        } catch (NullPointerException e) {
            res++;
        }

        try {
            res += obj.a;
            res += 1000;
        } catch (RuntimeException e) {
            res++;
        }

        try {
            res += obj.a;
            res += 1000;
        } catch (Exception e) {
            res++;
        }

        try {
            res += obj.a;
            res += 1000;
        } catch (Throwable e) {
            res++;
        }

        return res;
    }
}
