package testclasses.exceptions.negativesize.multidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class CatchNegativeArraySizeInt {
    private int[][][][] array;

    public CatchNegativeArraySizeInt() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec() {
        int res = 0;
        try {
            this.array = new int[-1][1][1][1];
            res += 1000;
        } catch (NegativeArraySizeException e) {
            res++;
        }

        try {
            this.array = new int[1][-1][1][1];
            res += 1000;
        } catch (RuntimeException e) {
            res++;
        }

        try {
            this.array = new int[1][1][-1][1];
            res += 1000;
        } catch (Exception e) {
            res++;
        }

        try {
            this.array = new int[1][1][1][-1];
            res += 1000;
        } catch (Throwable e) {
            res++;
        }

        return res;
    }
}
