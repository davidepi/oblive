package testclasses.exceptions.nullpointer.arraystore;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassBoolean;

public class CatchNullPointerExceptionXSTOREBoolean {

    public CatchNullPointerExceptionXSTOREBoolean() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec(SupportClassBoolean obj) {
        int res = 0;
        try {
            obj.b[1] = false;
            res += 1000;
        } catch (NullPointerException e) {
            res++;
        }

        try {
            obj.b[1] = true;
            res += 1000;
        } catch (RuntimeException e) {
            res++;
        }

        try {
            obj.b[1] = false;
            res += 1000;
        } catch (Exception e) {
            res++;
        }

        try {
            obj.b[1] = true;
            res += 1000;
        } catch (Throwable e) {
            res++;
        }

        return res;
    }
}
