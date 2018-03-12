package testclasses.stack;


import it.se.obfuscator.Obfuscate;

//BIPUSH
public class BConst
{
    public BConst()
    {

    }

    @Obfuscate
    public int exec()
    {
        byte a = -30;
        byte b = 120;
        return a+b;
    }
}
