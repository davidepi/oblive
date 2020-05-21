package testclasses.exceptions.outofbounds.arrayload;

import it.oblive.annotations.NativeObfuscation;

public class CatchArrayLoadOutOfBoundsLong {
    private long[] array;

    public CatchArrayLoadOutOfBoundsLong() {
        this.array = new long[2];
    }

    @NativeObfuscation
    public long exec() {
        int res = 0;

        try {
            res += (int) this.array[2];
            res += 1000;
        } catch (ArrayIndexOutOfBoundsException e) {
            res++;
        }

        try {
            res += (int) this.array[2];
            res += 1000;
        } catch (IndexOutOfBoundsException e) {
            res++;
        }

        try {
            res += (int) this.array[2];
            res += 1000;
        } catch (RuntimeException e) {
            res++;
        }

        try {
            res += (int) this.array[2];
            res += 1000;
        } catch (Exception e) {
            res++;
        }

        try {
            res += (int) this.array[2];
            res += 1000;
        } catch (Throwable e) {
            res++;
        }

        return res;
    }
}
