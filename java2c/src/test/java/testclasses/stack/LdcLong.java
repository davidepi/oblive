package testclasses.stack;


import it.se.obfuscator.Obfuscate;

public class LdcLong
{
    public LdcLong()
    {

    }

    @Obfuscate
    public long exec()
    {
        long a = 1000000000000L;
        long b = -1000000000001L;
        return a+b;
    }
}
