package testclasses.exceptions.nullpointer.arraylength;

import it.oblive.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassFloat;

public class CatchNullPointerExceptionArrayLengthFloat {

    public CatchNullPointerExceptionArrayLengthFloat() {

    }

    @NativeObfuscation
    public int exec(SupportClassFloat obj) {
        int res = 0;
        try {
            res = obj.b.length;
            res += 1000;
        } catch (NullPointerException e) {
            res++;
        }

        try {
            res = obj.b.length;
            res += 1000;
        } catch (RuntimeException e) {
            res++;
        }

        try {
            res = obj.b.length;
            res += 1000;
        } catch (Exception e) {
            res++;
        }

        try {
            res = obj.b.length;
            res += 1000;
        } catch (Throwable e) {
            res++;
        }

        return res;
    }
}
