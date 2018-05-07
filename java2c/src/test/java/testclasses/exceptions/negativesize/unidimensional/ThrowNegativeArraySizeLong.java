package testclasses.exceptions.negativesize.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowNegativeArraySizeLong
{
    private long array[];
    public ThrowNegativeArraySizeLong()
    {

    }

    @Obfuscation
    public int exec()
    {
        this.array = new long[-1];
        return 0;
    }
}
