package testclasses.invoke.overflow;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class OverflowLong
{
    long a;
    long b;
    long c;

    public OverflowLong()
    {
        a = Long.MAX_VALUE;
        b = 1;
        c = a+b;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public boolean add(long a, long b)
    {
        this.b = this.c;
        long r0 = normalAdd(a, b);
        long r1 = (a+b);
        return r0==r1 && r1==this.c;
    }

    public long normalAdd(long a, long b)
    {
        return a + b;
    }
}