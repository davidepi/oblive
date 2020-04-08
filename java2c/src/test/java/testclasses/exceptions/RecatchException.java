package testclasses.exceptions;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class RecatchException {
    public RecatchException() {

    }

    @NativeObfuscation
    public int exec() {
        int res = 0;
        try {
            throw new ClassCastException();
        } catch (ClassCastException e) {
            try {
                throw null;
            } catch (NullPointerException e1) {
                try {
                    throw new ClassCastException();
                } catch (ClassCastException e2) {
                    res = 1000;
                }
            }
        }
        return res;
    }
}
