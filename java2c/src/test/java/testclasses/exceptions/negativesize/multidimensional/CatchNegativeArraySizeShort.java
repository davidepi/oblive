package testclasses.exceptions.negativesize.multidimensional;

import it.oblive.annotations.NativeObfuscation;

public class CatchNegativeArraySizeShort {
    private short[][][][] array;

    public CatchNegativeArraySizeShort() {

    }

    @NativeObfuscation
    public int exec() {
        int res = 0;
        try {
            this.array = new short[-1][1][1][1];
            res += 1000;
        } catch (NegativeArraySizeException e) {
            res++;
        }

        try {
            this.array = new short[1][-1][1][1];
            res += 1000;
        } catch (RuntimeException e) {
            res++;
        }

        try {
            this.array = new short[1][1][-1][1];
            res += 1000;
        } catch (Exception e) {
            res++;
        }

        try {
            this.array = new short[1][1][1][-1];
            res += 1000;
        } catch (Throwable e) {
            res++;
        }

        return res;
    }
}
