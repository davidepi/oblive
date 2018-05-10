package testclasses.exceptions.negativesize.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowNegativeArraySizeInt
{
    private int array[];

    public ThrowNegativeArraySizeInt()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec()
    {
        this.array = new int[-1];
        return 0;
    }
}
