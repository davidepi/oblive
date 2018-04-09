package testclasses.exceptions.negativesize.multidimensional;

import it.se.obfuscator.Obfuscate;

public class ThrowNegativeArraySizeChar
{
    private char array[][][];
    public ThrowNegativeArraySizeChar()
    {

    }

    @Obfuscate
    public int exec()
    {
        this.array = new char[-1][1][1];
        return 0;
    }
}
