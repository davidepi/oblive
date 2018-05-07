package testclasses.stack;


import eu.fbk.hardening.annotation.Obfuscation;

//BIPUSH
public class BConst
{
    public BConst()
    {

    }

    @Obfuscation
    public int exec()
    {
        byte a = -30;
        byte b = 120;
        return a+b;
    }
}
