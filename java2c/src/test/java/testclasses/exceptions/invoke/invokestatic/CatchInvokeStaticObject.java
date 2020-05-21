package testclasses.exceptions.invoke.invokestatic;

import it.oblive.annotations.NativeObfuscation;
import testclasses.exceptions.UserDefinedException;

public class CatchInvokeStaticObject {
    public CatchInvokeStaticObject() {

    }

    public static Object normalDiv(int a, int b) {
        return a / b;
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

    public void other() throws UserDefinedException {
        throw new UserDefinedException();
    }
}
