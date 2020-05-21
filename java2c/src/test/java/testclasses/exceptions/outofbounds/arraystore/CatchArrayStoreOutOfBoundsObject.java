package testclasses.exceptions.outofbounds.arraystore;

import it.oblive.annotations.NativeObfuscation;

public class CatchArrayStoreOutOfBoundsObject {
    private String[] array;

    public CatchArrayStoreOutOfBoundsObject() {
        this.array = new String[2];
    }

    @NativeObfuscation
    public String exec() {
        int res = 0;

        try {
            this.array[2] = "str0";
            res += 1000;
        } catch (ArrayIndexOutOfBoundsException e) {
            res++;
        }

        try {
            this.array[2] = "str1";
            res += 1000;
        } catch (IndexOutOfBoundsException e) {
            res++;
        }

        try {
            this.array[2] = "str2";
            res += 1000;
        } catch (RuntimeException e) {
            res++;
        }

        try {
            this.array[2] = "str3";
            res += 1000;
        } catch (Exception e) {
            res++;
        }

        try {
            this.array[2] = "str4";
            res += 1000;
        } catch (Throwable e) {
            res++;
        }

        return ((Integer) res).toString();
    }
}
