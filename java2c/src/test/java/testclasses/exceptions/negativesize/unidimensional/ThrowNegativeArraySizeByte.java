package testclasses.exceptions.negativesize.unidimensional;

import it.se.obfuscator.Obfuscate;

public class ThrowNegativeArraySizeByte
{
    private byte array[];
    public ThrowNegativeArraySizeByte()
    {

    }

    @Obfuscate
    public int exec()
    {
        this.array = new byte[-1];
        return 0;
    }
}
