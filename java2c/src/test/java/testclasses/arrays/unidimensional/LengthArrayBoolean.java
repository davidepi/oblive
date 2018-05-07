package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;

public class LengthArrayBoolean
{
    private boolean[] array;

    public LengthArrayBoolean()
    {
        this.array = new boolean[61];
    }

    @Obfuscation
    public int getLen()
    {
        return this.array.length;
    }

}
