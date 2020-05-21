package testclasses.stack;


import it.oblive.annotations.NativeObfuscation;

//DCONST_0, DCONST_1, DADD, DSTORE, DLOAD
public class DConst {
    public DConst() {

    }

    @NativeObfuscation
    public double exec() {
        double a = 0.0;
        double b = 1.0;
        double c = a + b;
        return c + a;
    }
}
