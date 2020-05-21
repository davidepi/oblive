package testclasses.exceptions.nullpointer.arrayload;

import it.oblive.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassObject;

public class CatchNullPointerExceptionXLOADObject {

    public CatchNullPointerExceptionXLOADObject() {

    }

    @NativeObfuscation
    public int exec(SupportClassObject obj) {
        int res = 0;
        try {
            res += obj.b[1].length();
            res += 1000;
        } catch (NullPointerException e) {
            res++;
        }

        try {
            res += obj.b[1].length();
            res += 1000;
        } catch (RuntimeException e) {
            res++;
        }

        try {
            res += obj.b[1].length();
            res += 1000;
        } catch (Exception e) {
            res++;
        }

        try {
            res += obj.b[1].length();
            res += 1000;
        } catch (Throwable e) {
            res++;
        }

        return res;
    }
}
