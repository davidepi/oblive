package testclasses.exceptions.outofbounds.arraystore;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowArrayStoreOutOfBoundsShort
{
    private short array[];
    public ThrowArrayStoreOutOfBoundsShort()
    {
        this.array = new short[2];
    }

    @Obfuscation
    public short exec()
    {
        this.array[2] = 1;
        return this.array[2];
    }
}
