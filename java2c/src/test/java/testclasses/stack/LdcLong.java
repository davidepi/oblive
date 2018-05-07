package testclasses.stack;


import eu.fbk.hardening.annotation.Obfuscation;

public class LdcLong
{
    public LdcLong()
    {

    }

    @Obfuscation
    public long exec()
    {
        long a = 1000000000000L;
        long b = -1000000000001L;
        return a+b;
    }
}
