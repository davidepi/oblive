package testclasses.exceptions.outofbounds.arrayload;

import it.se.obfuscator.Obfuscate;

public class ThrowArrayLoadOutOfBoundsInt
{
    private int array[];
    public ThrowArrayLoadOutOfBoundsInt()
    {
        this.array = new int[2];
    }

    @Obfuscate
    public int exec()
    {
        return this.array[2];
    }
}
