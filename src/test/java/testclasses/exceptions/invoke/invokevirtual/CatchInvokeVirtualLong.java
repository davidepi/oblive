package testclasses.exceptions.invoke.invokevirtual;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.UserDefinedException;

public class CatchInvokeVirtualLong {
    public CatchInvokeVirtualLong() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int div(int a) {
        int res = 0;
        try {
            res = (int) normalDiv(a, 0);
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

    public long normalDiv(int a, int b) {
        return (long) (a / b);
    }

    public void other() throws UserDefinedException {
        throw new UserDefinedException();
    }
}