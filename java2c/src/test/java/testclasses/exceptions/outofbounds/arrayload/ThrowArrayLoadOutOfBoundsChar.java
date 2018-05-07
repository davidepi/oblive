package testclasses.exceptions.outofbounds.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowArrayLoadOutOfBoundsChar
{
    private char array[];
    public ThrowArrayLoadOutOfBoundsChar()
    {
        this.array = new char[2];
    }

    @Obfuscation
    public char exec()
    {
        return this.array[2];
    }
}
