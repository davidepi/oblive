package testclasses.exceptions.outofbounds.arrayload;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class CatchArrayLoadOutOfBoundsFloat {
    private float[] array;

    public CatchArrayLoadOutOfBoundsFloat() {
        this.array = new float[2];
    }

    @NativeObfuscation
    public float exec() {
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

        return (float) res;
    }
}
