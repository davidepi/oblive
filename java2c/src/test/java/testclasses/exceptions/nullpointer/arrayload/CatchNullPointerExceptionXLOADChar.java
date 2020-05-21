package testclasses.exceptions.nullpointer.arrayload;

import it.oblive.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassChar;

public class CatchNullPointerExceptionXLOADChar {

    public CatchNullPointerExceptionXLOADChar() {

    }

    @NativeObfuscation
    public int exec(SupportClassChar obj) {

        int res = 0;
        try {
            res += obj.b[1];
            res += 1000;
        } catch (NullPointerException e) {
            res++;
        }

        try {
            res += obj.b[1];
            res += 1000;
        } catch (RuntimeException e) {
            res++;
        }

        try {
            res += obj.b[1];
            res += 1000;
        } catch (Exception e) {
            res++;
        }

        try {
            res += obj.b[1];
            res += 1000;
        } catch (Throwable e) {
            res++;
        }

        return res;
    }
}
