package testclasses.conditionals;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class Ifdcmp
{
    public Ifdcmp()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec(double value)
    {
        int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0;
        double compareme = 3.5;
        if (value == compareme)
            a = 1;
        if (value != compareme)
            b = 10;
        if (value < compareme)
            c = 100;
        if (value <= compareme)
            d = 1000;
        if (value > compareme)
            e = 10000;
        if (value >= compareme)
            f = 100000;
        return a + b + c + d + e + f;
    }

}
