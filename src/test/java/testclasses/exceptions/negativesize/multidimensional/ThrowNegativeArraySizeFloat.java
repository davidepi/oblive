package testclasses.exceptions.negativesize.multidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowNegativeArraySizeFloat
{
    private float array[][][];

    public ThrowNegativeArraySizeFloat()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec()
    {
        this.array = new float[-1][1][1];
        return 0;
    }
}
