package testclasses.exceptions.negativesize.unidimensional;

import it.oblive.annotations.NativeObfuscation;

public class CatchNegativeArraySizeObject {
    private Object[] array;

    public CatchNegativeArraySizeObject() {

    }

    @NativeObfuscation
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
