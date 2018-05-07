package testclasses.exceptions.negativesize.multidimensional;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowNegativeArraySizeByte
{
    private byte array[][][];
    public ThrowNegativeArraySizeByte()
    {

    }

    @Obfuscation
    public int exec()
    {
        this.array = new byte[-1][1][1];
        return 0;
    }
}
