package testclasses.stack;


import eu.fbk.hardening.annotation.Obfuscation;

//SIPUSH
public class SConst
{
    public SConst()
    {

    }

    @Obfuscation
    public int exec()
    {
        short a = -3000;
        short b = 12000;
        return a+b;
    }
}
