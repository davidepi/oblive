package testclasses.stack;


import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class LdcStringASCII
{
    public LdcStringASCII()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public String exec()
    {
        return "hello";
    }
}
