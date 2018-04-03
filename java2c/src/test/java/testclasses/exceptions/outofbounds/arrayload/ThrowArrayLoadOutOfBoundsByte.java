package testclasses.exceptions.outofbounds.arrayload;

import it.se.obfuscator.Obfuscate;

public class ThrowArrayLoadOutOfBoundsByte
{
    private byte array[];
    public ThrowArrayLoadOutOfBoundsByte()
    {
        this.array = new byte[2];
    }

    @Obfuscate
    public byte exec()
    {
        return this.array[2];
    }
}
