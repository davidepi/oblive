package testclasses.antidebug;

import it.oblive.annotations.AntidebugSelf;
import it.oblive.annotations.NativeObfuscation;

import java.time.Duration;
import java.time.Instant;

public class AntidebugSelfDebugging {
    public AntidebugSelfDebugging() {

    }

    public static String pi(int digits) {
        Instant start = Instant.now();
        String retval = piInternal(digits);
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println(duration.getSeconds()+"."+duration.getNano());
        return retval;
    }

    @NativeObfuscation
    @AntidebugSelf
    public static String piInternal(int digits) {
        StringBuffer pi = new StringBuffer();
        int[] arr = new int[digits + 1];
        int carry = 0;

        for (int i = 0; i <= digits; ++i)
            arr[i] = 2000;

        for (int i = digits; i > 0; i-= 14) {
            int sum = 0;
            for (int j = i; j > 0; --j) {
                sum = sum * j + 10000 * arr[j];
                arr[j] = sum % (j * 2 - 1);
                sum /= j * 2 - 1;
            }

            pi.append(String.format("%04d", carry + sum / 10000));
            carry = sum % 10000;
        }
        return pi.toString();
    }
}
