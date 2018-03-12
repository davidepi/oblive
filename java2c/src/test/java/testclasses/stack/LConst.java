package testclasses.stack;


import it.se.obfuscator.Obfuscate;

//LCONST_0, LCONST_1, LADD, LSTORE, LLOAD
public class LConst
{
    public LConst()
    {

    }

    @Obfuscate
    public long exec()
    {
        long a = 0;
        long b = 1;
        long c = a+b;
        return c+a;
    }
}
