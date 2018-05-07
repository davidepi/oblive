package testclasses.stack;


import eu.fbk.hardening.annotation.Obfuscation;

public class LdcStringASCII
{
    public LdcStringASCII()
    {

    }

    @Obfuscation
    public String exec()
    {
        return "hello";
    }
}
