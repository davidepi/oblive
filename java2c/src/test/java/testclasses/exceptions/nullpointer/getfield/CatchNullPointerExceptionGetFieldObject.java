package testclasses.exceptions.nullpointer.getfield;

import eu.fbk.hardening.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassObject;

public class CatchNullPointerExceptionGetFieldObject {

    public CatchNullPointerExceptionGetFieldObject() {

    }

    @NativeObfuscation
    public int exec(SupportClassObject obj) {
        int res = 0;
        try {
            res += obj.a.length();
            res += 1000;
        } catch (NullPointerException e) {
            res++;
        }

        try {
            res += obj.a.length();
            res += 1000;
        } catch (RuntimeException e) {
            res++;
        }

        try {
            res += obj.a.length();
            res += 1000;
        } catch (Exception e) {
            res++;
        }

        try {
            res += obj.a.length();
            res += 1000;
        } catch (Throwable e) {
            res++;
        }

        return res;
    }
}
