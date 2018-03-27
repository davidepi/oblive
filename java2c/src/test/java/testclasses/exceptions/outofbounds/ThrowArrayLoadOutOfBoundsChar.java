package testclasses.exceptions.outofbounds;

import it.se.obfuscator.Obfuscate;

public class ThrowArrayLoadOutOfBoundsChar
{
    private char array[];
    public ThrowArrayLoadOutOfBoundsChar()
    {
        this.array = new char[2];
    }

    @Obfuscate
    public char exec()
    {
        return this.array[2];
    }
}
