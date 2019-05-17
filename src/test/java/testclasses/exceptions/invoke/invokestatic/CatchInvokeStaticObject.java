package testclasses.exceptions.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.UserDefinedException;

public class CatchInvokeStaticObject {
    public CatchInvokeStaticObject() {

    }

    public static Object normalDiv(int a, int b) {
        return a / b;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
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