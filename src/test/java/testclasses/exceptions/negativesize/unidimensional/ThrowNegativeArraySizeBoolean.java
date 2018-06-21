package testclasses.exceptions.negativesize.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowNegativeArraySizeBoolean
{
    private boolean array[];

    public ThrowNegativeArraySizeBoolean()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec()
    {
        this.array = new boolean[-1];
        return 0;
    }
}
