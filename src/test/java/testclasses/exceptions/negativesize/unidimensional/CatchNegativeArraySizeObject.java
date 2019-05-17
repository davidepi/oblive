package testclasses.exceptions.negativesize.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class CatchNegativeArraySizeObject {
    private Object[] array;

    public CatchNegativeArraySizeObject() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec() {
        int res = 0;
        try {
            this.array = new String[-1];
            res += 1000;
        } catch (NegativeArraySizeException e) {
            res++;
        }

        try {
            this.array = new String[-1];
            res += 1000;
        } catch (RuntimeException e) {
            res++;
        }

        try {
            this.array = new String[-1];
            res += 1000;
        } catch (Exception e) {
            res++;
        }

        try {
            this.array = new String[-1];
            res += 1000;
        } catch (Throwable e) {
            res++;
        }

        return res;
    }
}