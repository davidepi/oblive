package testclasses.exceptions.negativesize.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowNegativeArraySizeByte
{
    private byte array[];
    public ThrowNegativeArraySizeByte()
    {

    }

    @Obfuscation
    public int exec()
    {
        this.array = new byte[-1];
        return 0;
    }
}
