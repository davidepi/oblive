package testclasses.stack;


import eu.fbk.hardening.annotation.Obfuscation;

//LCONST_0, LCONST_1, LADD, LSTORE, LLOAD
public class LConst
{
    public LConst()
    {

    }

    @Obfuscation
    public long exec()
    {
        long a = 0;
        long b = 1;
        long c = a+b;
        return c+a;
    }
}
