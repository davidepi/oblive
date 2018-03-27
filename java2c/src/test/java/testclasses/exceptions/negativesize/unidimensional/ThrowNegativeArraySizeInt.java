package testclasses.exceptions.negativesize.unidimensional;

import it.se.obfuscator.Obfuscate;

public class ThrowNegativeArraySizeInt
{
    private int array[];
    public ThrowNegativeArraySizeInt()
    {

    }

    @Obfuscate
    public int exec()
    {
        this.array = new int[-1];
        return 0;
    }
}
