package testclasses.stack;


import it.se.obfuscator.Obfuscate;

public class LdcFloat
{
    public LdcFloat()
    {

    }

    @Obfuscate
    public float exec()
    {
        float a = 3.5f;
        float b = -0.5f;
        return a+b;
    }
}
