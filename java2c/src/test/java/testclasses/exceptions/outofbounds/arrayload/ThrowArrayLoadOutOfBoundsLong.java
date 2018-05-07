package testclasses.exceptions.outofbounds.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowArrayLoadOutOfBoundsLong
{
    private long array[];
    public ThrowArrayLoadOutOfBoundsLong()
    {
        this.array = new long[2];
    }

    @Obfuscation
    public long exec()
    {
        return this.array[2];
    }
}
