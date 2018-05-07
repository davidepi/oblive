package testclasses.exceptions.negativesize.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowNegativeArraySizeBoolean
{
    private boolean array[];
    public ThrowNegativeArraySizeBoolean()
    {

    }

    @Obfuscation
    public int exec()
    {
        this.array = new boolean[-1];
        return 0;
    }
}
