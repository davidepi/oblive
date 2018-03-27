package testclasses.exceptions.negativesize.multidimensional;

import it.se.obfuscator.Obfuscate;

public class ThrowNegativeArraySizeObject
{
    private Object array[][][];
    public ThrowNegativeArraySizeObject()
    {

    }

    @Obfuscate
    public int exec()
    {
        this.array = new String[-1][1][1];
        return 0;
    }
}
