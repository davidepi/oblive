package testclasses.stack;


import it.se.obfuscator.Obfuscate;

//DCONST_0, DCONST_1, DADD, DSTORE, DLOAD
public class DConst
{
    public DConst()
    {

    }

    @Obfuscate
    public double exec()
    {
        double a = 0.0;
        double b = 1.0;
        double c = a+b;
        return c+a;
    }
}
