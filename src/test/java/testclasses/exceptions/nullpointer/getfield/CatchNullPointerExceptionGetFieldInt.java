package testclasses.exceptions.nullpointer.getfield;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassInt;

public class CatchNullPointerExceptionGetFieldInt {

    public CatchNullPointerExceptionGetFieldInt() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec(SupportClassInt obj) {
        int res = 0;
        try {
            res += obj.a;
            res += 1000;
        } catch (NullPointerException e) {
            res++;
        }

        try {
            res += obj.a;
            res += 1000;
        } catch (RuntimeException e) {
            res++;
        }

        try {
            res += obj.a;
            res += 1000;
        } catch (Exception e) {
            res++;
        }

        try {
            res += obj.a;
            res += 1000;
        } catch (Throwable e) {
            res++;
        }

        return res;
    }
}
