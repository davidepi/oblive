package testclasses.exceptions.negativesize.multidimensional;

import it.oblive.annotations.NativeObfuscation;

public class CatchNegativeArraySizeBoolean {
    private boolean[][][][] array;

    public CatchNegativeArraySizeBoolean() {

    }

    @NativeObfuscation
    public int exec() {
        int res = 0;
        try {
            this.array = new boolean[-1][1][1][1];
            res += 1000;
        } catch (NegativeArraySizeException e) {
            res++;
        }

        try {
            this.array = new boolean[1][-1][1][1];
            res += 1000;
        } catch (RuntimeException e) {
            res++;
        }

        try {
            this.array = new boolean[1][1][-1][1];
            res += 1000;
        } catch (Exception e) {
            res++;
        }

        try {
            this.array = new boolean[1][1][1][-1];
            res += 1000;
        } catch (Throwable e) {
            res++;
        }

        return res;
    }
}
