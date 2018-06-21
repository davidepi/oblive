package testclasses.invoke.overflow;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class OverflowInt
{
    int a;
    int b;
    int c;

    public OverflowInt()
    {
        a = Integer.MAX_VALUE;
        b = 1;
        c = a+b;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public boolean add(int a, int b)
    {
        this.b = this.c;
        int r0 = normalAdd(a, b);
        int r1 = (a+b);
        return r0==r1 && r1==this.c;
    }

    public int normalAdd(int a, int b)
    {
        return a + b;
    }
}