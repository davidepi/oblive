package testclasses.exceptions.nullpointer.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassObject;

public class CatchNullPointerExceptionXLOADObject {

    public CatchNullPointerExceptionXLOADObject() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
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