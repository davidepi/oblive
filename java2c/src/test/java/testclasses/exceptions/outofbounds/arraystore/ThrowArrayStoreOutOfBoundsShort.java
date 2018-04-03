package testclasses.exceptions.outofbounds.arraystore;

import it.se.obfuscator.Obfuscate;

public class ThrowArrayStoreOutOfBoundsShort
{
    private short array[];
    public ThrowArrayStoreOutOfBoundsShort()
    {
        this.array = new short[2];
    }

    @Obfuscate
    public short exec()
    {
        this.array[2] = 1;
        return this.array[2];
    }
}
