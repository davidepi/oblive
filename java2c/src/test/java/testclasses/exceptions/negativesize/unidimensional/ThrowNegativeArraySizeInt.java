package testclasses.exceptions.negativesize.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowNegativeArraySizeInt
{
    private int array[];
    public ThrowNegativeArraySizeInt()
    {

    }

    @Obfuscation
    public int exec()
    {
        this.array = new int[-1];
        return 0;
    }
}
