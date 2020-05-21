package testclasses.stack;

import it.oblive.annotations.NativeObfuscation;

public class Dup2 {
    public Dup2() {

    }

    @NativeObfuscation
    public double exec() {
        double a = 2.5;
        double b = 3.5;
        return a = b++;
    }
}
