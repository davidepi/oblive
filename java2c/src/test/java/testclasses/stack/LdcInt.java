package testclasses.stack;


import it.se.obfuscator.Obfuscate;

public class LdcInt
{
    public LdcInt()
    {

    }

    @Obfuscate
    public int exec()
    {
        int a = 1000000000;
        int b = -1000000001;
        return a+b;
    }
}
