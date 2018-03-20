package testclasses.arrays.unidimensional;

import it.se.obfuscator.Obfuscate;

public class LengthArrayBoolean
{
    private boolean[] array;

    public LengthArrayBoolean()
    {
        this.array = new boolean[61];
    }

    @Obfuscate
    public int getLen()
    {
        return this.array.length;
    }

}
