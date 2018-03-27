package testclasses.exceptions.negativesize.unidimensional;

import it.se.obfuscator.Obfuscate;

public class ThrowNegativeArraySizeFloat
{
    private float array[];
    public ThrowNegativeArraySizeFloat()
    {

    }

    @Obfuscate
    public int exec()
    {
        this.array = new float[-1];
        return 0;
    }
}
