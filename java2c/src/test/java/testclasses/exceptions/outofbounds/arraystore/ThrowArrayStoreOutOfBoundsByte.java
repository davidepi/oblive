package testclasses.exceptions.outofbounds.arraystore;

import it.se.obfuscator.Obfuscate;

public class ThrowArrayStoreOutOfBoundsByte
{
    private byte array[];
    public ThrowArrayStoreOutOfBoundsByte()
    {
        this.array = new byte[2];
    }

    @Obfuscate
    public byte exec()
    {
        this.array[2] = 1;
        return this.array[2];
    }
}
