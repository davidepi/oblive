package testclasses.stack;


import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class LdcLong
{
    public LdcLong()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public long exec()
    {
        long a = 1000000000000L;
        long b = -1000000000001L;
        return a + b;
    }
}
