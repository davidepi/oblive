package testclasses.stack;


import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

//FCONST_0, FCONST_1, FCONST_2, FADD, FSTORE, FLOAD
public class FConst
{
    public FConst()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public float exec()
    {
        float a = 0.f;
        float b = 1.f;
        float c = a + b;
        return c + 2.f;
    }
}
