package testclasses.exceptions.negativesize.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowNegativeArraySizeShort
{
    private short array[];
    public ThrowNegativeArraySizeShort()
    {

    }

    @Obfuscation
    public int exec()
    {
        this.array = new short[-1];
        return 0;
    }
}
