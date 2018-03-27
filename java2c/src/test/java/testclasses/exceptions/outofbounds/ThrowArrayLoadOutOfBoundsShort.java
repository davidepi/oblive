package testclasses.exceptions.outofbounds;

import it.se.obfuscator.Obfuscate;

public class ThrowArrayLoadOutOfBoundsShort
{
    private short array[];
    public ThrowArrayLoadOutOfBoundsShort()
    {
        this.array = new short[2];
    }

    @Obfuscate
    public short exec()
    {
        return this.array[2];
    }
}
