package testclasses.exceptions.negativesize.unidimensional;

import it.se.obfuscator.Obfuscate;

public class ThrowNegativeArraySizeObject
{
    private Object array[];
    public ThrowNegativeArraySizeObject()
    {

    }

    @Obfuscate
    public int exec()
    {
        this.array = new String[-1];
        return 0;
    }
}
