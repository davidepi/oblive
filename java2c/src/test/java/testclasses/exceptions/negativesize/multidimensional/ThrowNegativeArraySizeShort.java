package testclasses.exceptions.negativesize.multidimensional;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowNegativeArraySizeShort
{
    private short array[][][];
    public ThrowNegativeArraySizeShort()
    {

    }

    @Obfuscation
    public int exec()
    {
        this.array = new short[-1][1][1];
        return 0;
    }
}
