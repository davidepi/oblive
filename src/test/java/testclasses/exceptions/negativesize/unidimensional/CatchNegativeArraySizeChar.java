package testclasses.exceptions.negativesize.unidimensional;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class CatchNegativeArraySizeChar {
    private char[] array;

    public CatchNegativeArraySizeChar() {

    }

    @NativeObfuscation
    public int exec() {
        int res = 0;
        try {
            this.array = new char[-1];
            res += 1000;
        } catch (NegativeArraySizeException e) {
            res++;
        }

        try {
            this.array = new char[-1];
            res += 1000;
        } catch (RuntimeException e) {
            res++;
        }

        try {
            this.array = new char[-1];
            res += 1000;
        } catch (Exception e) {
            res++;
        }

        try {
            this.array = new char[-1];
            res += 1000;
        } catch (Throwable e) {
            res++;
        }

        return res;
    }
}
