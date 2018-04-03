package testclasses.exceptions.outofbounds.arraystore;

import it.se.obfuscator.Obfuscate;

public class ThrowArrayStoreOutOfBoundsChar
{
    private char array[];
    public ThrowArrayStoreOutOfBoundsChar()
    {
        this.array = new char[2];
    }

    @Obfuscate
    public char exec()
    {
        this.array[2] = 1;
        return this.array[2];
    }
}
