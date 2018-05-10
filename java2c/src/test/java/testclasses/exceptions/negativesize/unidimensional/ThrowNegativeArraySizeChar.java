package testclasses.exceptions.negativesize.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowNegativeArraySizeChar
{
    private char array[];

    public ThrowNegativeArraySizeChar()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec()
    {
        this.array = new char[-1];
        return 0;
    }
}
