package testclasses.arrays.multidimensional;

import it.se.obfuscator.Obfuscate;

public class LengthArrayBoolean
{
    private boolean[][] array;

    public LengthArrayBoolean()
    {
        this.array = new boolean[3][2];
    }

    @Obfuscate
    public int getLen()
    {
        return this.array.length;
    }

}
