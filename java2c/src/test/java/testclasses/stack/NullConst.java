package testclasses.stack;


import eu.fbk.hardening.annotation.Obfuscation;

//BIPUSH
public class NullConst
{
    public NullConst()
    {

    }

    @Obfuscation
    public Object exec()
    {
        return null;
    }
}
