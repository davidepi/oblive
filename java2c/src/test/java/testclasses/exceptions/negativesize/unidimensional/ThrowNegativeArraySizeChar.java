package testclasses.exceptions.negativesize.unidimensional;

import it.se.obfuscator.Obfuscate;

public class ThrowNegativeArraySizeChar
{
    private char array[];
    public ThrowNegativeArraySizeChar()
    {

    }

    @Obfuscate
    public int exec()
    {
        this.array = new char[-1];
        return 0;
    }
}
