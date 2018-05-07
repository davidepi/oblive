package testclasses.exceptions.negativesize.multidimensional;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowNegativeArraySizeChar
{
    private char array[][][];
    public ThrowNegativeArraySizeChar()
    {

    }

    @Obfuscation
    public int exec()
    {
        this.array = new char[-1][1][1];
        return 0;
    }
}
