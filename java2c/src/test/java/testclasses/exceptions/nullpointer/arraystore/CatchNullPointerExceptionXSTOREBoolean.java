package testclasses.exceptions.nullpointer.arraystore;

import eu.fbk.hardening.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassBoolean;

public class CatchNullPointerExceptionXSTOREBoolean {

    public CatchNullPointerExceptionXSTOREBoolean() {

    }

    @NativeObfuscation
    public int exec(SupportClassBoolean obj) {
        int res = 0;
        try {
            obj.b[1] = false;
            res += 1000;
        } catch (NullPointerException e) {
            res++;
        }

        try {
            obj.b[1] = true;
            res += 1000;
        } catch (RuntimeException e) {
            res++;
        }

        try {
            obj.b[1] = false;
            res += 1000;
        } catch (Exception e) {
            res++;
        }

        try {
            obj.b[1] = true;
            res += 1000;
        } catch (Throwable e) {
            res++;
        }

        return res;
    }
}
