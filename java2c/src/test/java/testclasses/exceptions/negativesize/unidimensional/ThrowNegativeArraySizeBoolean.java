package testclasses.exceptions.negativesize.unidimensional;

import it.se.obfuscator.Obfuscate;

public class ThrowNegativeArraySizeBoolean
{
    private boolean array[];
    public ThrowNegativeArraySizeBoolean()
    {

    }

    @Obfuscate
    public int exec()
    {
        this.array = new boolean[-1];
        return 0;
    }
}
