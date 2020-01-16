package testclasses.exceptions.nullpointer.arrayload;

import eu.fbk.hardening.annotation.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassDouble;

public class CatchNullPointerExceptionXLOADDouble {

    public CatchNullPointerExceptionXLOADDouble() {

    }

    @NativeObfuscation
    public int exec(SupportClassDouble obj) {
        int res = 0;
        try {
            res += (int) obj.b[1];
            res += 1000;
        } catch (NullPointerException e) {
            res++;
        }

        try {
            res += (int) obj.b[1];
            res += 1000;
        } catch (RuntimeException e) {
            res++;
        }

        try {
            res += (int) obj.b[1];
            res += 1000;
        } catch (Exception e) {
            res++;
        }

        try {
            res += (int) obj.b[1];
            res += 1000;
        } catch (Throwable e) {
            res++;
        }

        return res;
    }
}
