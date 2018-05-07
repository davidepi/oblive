package testclasses.exceptions.outofbounds.arraystore;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowArrayStoreOutOfBoundsChar
{
    private char array[];
    public ThrowArrayStoreOutOfBoundsChar()
    {
        this.array = new char[2];
    }

    @Obfuscation
    public char exec()
    {
        this.array[2] = 1;
        return this.array[2];
    }
}
