package testclasses.exceptions.outofbounds.arraystore;

import it.se.obfuscator.Obfuscate;

public class ThrowArrayStoreOutOfBoundsLong
{
    private long array[];
    public ThrowArrayStoreOutOfBoundsLong()
    {
        this.array = new long[2];
    }

    @Obfuscate
    public long exec()
    {
        this.array[2] = 1;
        return this.array[2];
    }
}
