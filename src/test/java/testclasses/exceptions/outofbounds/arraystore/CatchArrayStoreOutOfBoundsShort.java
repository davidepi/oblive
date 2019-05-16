package testclasses.exceptions.outofbounds.arraystore;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class CatchArrayStoreOutOfBoundsShort {
    private short[] array;

    public CatchArrayStoreOutOfBoundsShort() {
        this.array = new short[2];
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec() {
        int res = 0;

        try {
            this.array[2] = 1;
            res += 1000;
        } catch (ArrayIndexOutOfBoundsException e) {
            res++;
        }

        try {
            this.array[2] = 0;
            res += 1000;
        } catch (IndexOutOfBoundsException e) {
            res++;
        }

        try {
            this.array[2] = 1;
            res += 1000;
        } catch (RuntimeException e) {
            res++;
        }

        try {
            this.array[2] = 0;
            res += 1000;
        } catch (Exception e) {
            res++;
        }

        try {
            this.array[2] = 1;
            res += 1000;
        } catch (Throwable e) {
            res++;
        }

        return (short) res;
    }
}
