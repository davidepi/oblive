package testclasses.exceptions.nullpointer.arraylength;

import eu.fbk.hardening.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassByte;

public class CatchNullPointerExceptionArrayLengthByte {

    public CatchNullPointerExceptionArrayLengthByte() {

    }

    @NativeObfuscation
    public int exec(SupportClassByte obj) {

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
