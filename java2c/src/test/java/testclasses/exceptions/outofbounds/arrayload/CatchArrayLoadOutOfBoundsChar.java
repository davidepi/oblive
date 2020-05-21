package testclasses.exceptions.outofbounds.arrayload;

import it.oblive.annotations.NativeObfuscation;

public class CatchArrayLoadOutOfBoundsChar {
    private char[] array;

    public CatchArrayLoadOutOfBoundsChar() {
        this.array = new char[2];
    }

    @NativeObfuscation
    public int exec() {
        int res = 0;

        try {
            res += this.array[2];
            res += 1000;
        } catch (ArrayIndexOutOfBoundsException e) {
            res++;
        }

        try {
            res += this.array[2];
            res += 1000;
        } catch (IndexOutOfBoundsException e) {
            res++;
        }

        try {
            res += this.array[2];
            res += 1000;
        } catch (RuntimeException e) {
            res++;
        }

        try {
            res += this.array[2];
            res += 1000;
        } catch (Exception e) {
            res++;
        }

        try {
            res += this.array[2];
            res += 1000;
        } catch (Throwable e) {
            res++;
        }

        return (char) res;
    }
}
