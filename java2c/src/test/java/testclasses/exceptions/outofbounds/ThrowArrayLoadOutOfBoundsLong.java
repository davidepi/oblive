package testclasses.exceptions.outofbounds;

import it.se.obfuscator.Obfuscate;

public class ThrowArrayLoadOutOfBoundsLong
{
    private long array[];
    public ThrowArrayLoadOutOfBoundsLong()
    {
        this.array = new long[2];
    }

    @Obfuscate
    public long exec()
    {
        return this.array[2];
    }
}
