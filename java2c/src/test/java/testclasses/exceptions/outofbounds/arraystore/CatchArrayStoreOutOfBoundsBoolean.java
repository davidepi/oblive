package testclasses.exceptions.outofbounds.arraystore;

import it.oblive.annotations.NativeObfuscation;

public class CatchArrayStoreOutOfBoundsBoolean {
    private boolean[] array;

    public CatchArrayStoreOutOfBoundsBoolean() {
        this.array = new boolean[2];
    }

    @NativeObfuscation
    public int exec() {
        int res = 0;

        try {
            this.array[2] = true;
            res += 1000;
        } catch (ArrayIndexOutOfBoundsException e) {
            res++;
        }

        try {
            this.array[2] = false;
            res += 1000;
        } catch (IndexOutOfBoundsException e) {
            res++;
        }

        try {
            this.array[2] = true;
            res += 1000;
        } catch (RuntimeException e) {
            res++;
        }

        try {
            this.array[2] = false;
            res += 1000;
        } catch (Exception e) {
            res++;
        }

        try {
            this.array[2] = true;
            res += 1000;
        } catch (Throwable e) {
            res++;
        }

        return res;
    }
}
