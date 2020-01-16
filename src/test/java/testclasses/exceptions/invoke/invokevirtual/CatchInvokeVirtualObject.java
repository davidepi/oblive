package testclasses.exceptions.invoke.invokevirtual;

import eu.fbk.hardening.annotation.NativeObfuscation;
import testclasses.exceptions.UserDefinedException;

public class CatchInvokeVirtualObject {
    public CatchInvokeVirtualObject() {

    }

    @NativeObfuscation
    public int div(int a) {
        int res = 0;
        try {
            res = ((Integer) normalDiv(a, 0));
        } catch (ArithmeticException e0) {
            try {
                other();
                res += 1000;
            } catch (UserDefinedException e1) {
                res++;
            } catch (Exception e) {
                res -= 10000;
            }
        }
        return res;
    }

    public Object normalDiv(int a, int b) {
        return a / b;
    }

    public void other() throws UserDefinedException {
        throw new UserDefinedException();
    }
}