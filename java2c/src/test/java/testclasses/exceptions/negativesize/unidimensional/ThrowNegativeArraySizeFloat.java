package testclasses.exceptions.negativesize.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowNegativeArraySizeFloat
{
    private float array[];
    public ThrowNegativeArraySizeFloat()
    {

    }

    @Obfuscation
    public int exec()
    {
        this.array = new float[-1];
        return 0;
    }
}
