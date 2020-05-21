package testclasses.exceptions.invoke.invokevirtual;

import it.oblive.annotations.NativeObfuscation;
import testclasses.exceptions.UserDefinedException;

public class CatchInvokeVirtualChar {
    public CatchInvokeVirtualChar() {

    }

    @NativeObfuscation
    public int div(int a) {
        int res = 0;
        try {
            res = normalDiv(a, 0);
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

    public char normalDiv(int a, int b) {
        return (char) (a / b);
    }

    public void other() throws UserDefinedException {
        throw new UserDefinedException();
    }
}