package testclasses.exceptions;

import it.oblive.annotations.NativeObfuscation;

public class CatchExceptionInNew {
    public CatchExceptionInNew() {

    }

    @NativeObfuscation
    public int exec() {
        int res = 0;
        try {
            new ClassExceptionInInit();
            res += 1000;
        } catch (Exception e) {
            res++;
        }
        return 0;
    }
}
