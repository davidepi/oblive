package testclasses.stack;


import eu.fbk.hardening.annotations.NativeObfuscation;

//ICONST_M1, ICONST_0, ICONST_1, ICONST_2, ICONST_3, ICONST_4, ICONST_5
public class IConst {
    public IConst() {

    }

    @NativeObfuscation
    public int exec() {
        int a = 0;
        int b = 1;
        int c = a + b;
        int d = c + 2;
        int e = d + 3;
        int f = e + 4;
        int g = f + 5;
        int h = -1;
        g += h;
        return g;
    }
}
