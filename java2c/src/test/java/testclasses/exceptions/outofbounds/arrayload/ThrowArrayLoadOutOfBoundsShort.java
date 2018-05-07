package testclasses.exceptions.outofbounds.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowArrayLoadOutOfBoundsShort
{
    private short array[];
    public ThrowArrayLoadOutOfBoundsShort()
    {
        this.array = new short[2];
    }

    @Obfuscation
    public short exec()
    {
        return this.array[2];
    }
}
