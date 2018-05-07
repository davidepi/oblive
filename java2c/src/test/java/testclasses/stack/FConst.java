package testclasses.stack;


import eu.fbk.hardening.annotation.Obfuscation;

//FCONST_0, FCONST_1, FCONST_2, FADD, FSTORE, FLOAD
public class FConst
{
    public FConst()
    {

    }

    @Obfuscation
    public float exec()
    {
        float a = 0.f;
        float b = 1.f;
        float c = a+b;
        return c+2.f;
    }
}
