package testclasses.exceptions.nullpointer.setfield;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassBoolean;

public class CatchNullPointerExceptionSetFieldBoolean {

    public CatchNullPointerExceptionSetFieldBoolean() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec(SupportClassBoolean obj) {
        int res = 0;
        try {
            obj.a = true;
            res += 1000;
        } catch (NullPointerException e) {
            res++;
        }

        try {
            obj.a = true;
            res += 1000;
        } catch (RuntimeException e) {
            res++;
        }

        try {
            obj.a = true;
            res += 1000;
        } catch (Exception e) {
            res++;
        }

        try {
            obj.a = true;
            res += 1000;
        } catch (Throwable e) {
            res++;
        }

        return res;
    }
}
