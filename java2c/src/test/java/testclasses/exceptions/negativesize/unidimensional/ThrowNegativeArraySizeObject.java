package testclasses.exceptions.negativesize.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowNegativeArraySizeObject
{
    private Object array[];
    public ThrowNegativeArraySizeObject()
    {

    }

    @Obfuscation
    public int exec()
    {
        this.array = new String[-1];
        return 0;
    }
}
