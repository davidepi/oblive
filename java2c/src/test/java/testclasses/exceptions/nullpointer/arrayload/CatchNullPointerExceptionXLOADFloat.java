package testclasses.exceptions.nullpointer.arrayload;

import it.oblive.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassFloat;

public class CatchNullPointerExceptionXLOADFloat {

    public CatchNullPointerExceptionXLOADFloat() {

    }

    @NativeObfuscation
    public int exec(SupportClassFloat obj) {
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
