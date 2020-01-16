package testclasses.exceptions.nullpointer.getfield;

import eu.fbk.hardening.annotation.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassByte;

public class CatchNullPointerExceptionGetFieldByte {

    public CatchNullPointerExceptionGetFieldByte() {

    }

    @NativeObfuscation
    public int exec(SupportClassByte obj) {
        int res = 0;
        try {
            res += (int) obj.a;
            res += 1000;
        } catch (NullPointerException e) {
            res++;
        }

        try {
            res += (int) obj.a;
            res += 1000;
        } catch (RuntimeException e) {
            res++;
        }

        try {
            res += (int) obj.a;
            res += 1000;
        } catch (Exception e) {
            res++;
        }

        try {
            res += (int) obj.a;
            res += 1000;
        } catch (Throwable e) {
            res++;
        }

        return res;
    }
}
