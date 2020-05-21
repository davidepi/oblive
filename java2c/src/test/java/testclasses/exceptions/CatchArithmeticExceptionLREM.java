package testclasses.exceptions;

import it.oblive.annotations.NativeObfuscation;

public class CatchArithmeticExceptionLREM {
    public CatchArithmeticExceptionLREM() {

    }

    @NativeObfuscation
    public static long divide(long a) {
        long res = 0;
        try {
            res += a % 0;
            res += 1000;
        } catch (ArithmeticException e) {
            res++;
        }

        try {
            res += a % 0;
            res += 1000;
        } catch (RuntimeException e) {
            res++;
        }

        try {
            res += a % 0;
            res += 1000;
        } catch (Exception e) {
            res++;
        }

        try {
            res += a % 0;
            res += 1000;
        } catch (Throwable e) {
            res++;
        }

        return res;
    }
}
