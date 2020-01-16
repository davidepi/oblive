package testclasses.exceptions.negativesize.unidimensional;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class CatchNegativeArraySizeLong {
    private long[] array;

    public CatchNegativeArraySizeLong() {

    }

    @NativeObfuscation
    public int exec() {
        int res = 0;
        try {
            this.array = new long[-1];
            res += 1000;
        } catch (NegativeArraySizeException e) {
            res++;
        }

        try {
            this.array = new long[-1];
            res += 1000;
        } catch (RuntimeException e) {
            res++;
        }

        try {
            this.array = new long[-1];
            res += 1000;
        } catch (Exception e) {
            res++;
        }

        try {
            this.array = new long[-1];
            res += 1000;
        } catch (Throwable e) {
            res++;
        }

        return res;
    }
}
