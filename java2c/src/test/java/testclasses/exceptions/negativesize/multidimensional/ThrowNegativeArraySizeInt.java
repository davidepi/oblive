package testclasses.exceptions.negativesize.multidimensional;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowNegativeArraySizeInt
{
    private int array[][][];
    public ThrowNegativeArraySizeInt()
    {

    }

    @Obfuscation
    public int exec()
    {
        this.array = new int[-1][1][1];
        return 0;
    }
}
