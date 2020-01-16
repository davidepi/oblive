package testclasses.exceptions.nullpointer.arraystore;

import eu.fbk.hardening.annotation.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassInt;

public class CatchNullPointerExceptionXSTOREInt {

    public CatchNullPointerExceptionXSTOREInt() {

    }

    @NativeObfuscation
    public int exec(SupportClassInt obj) {
        int res = 0;
        try {
            obj.b[1] = 1;
            res += 1000;
        } catch (NullPointerException e) {
            res++;
        }

        try {
            obj.b[1] = 0;
            res += 1000;
        } catch (RuntimeException e) {
            res++;
        }

        try {
            obj.b[1] = 1;
            res += 1000;
        } catch (Exception e) {
            res++;
        }

        try {
            obj.b[1] = 0;
            res += 1000;
        } catch (Throwable e) {
            res++;
        }

        return res;
    }
}
