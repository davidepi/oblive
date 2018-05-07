package testclasses.exceptions.outofbounds.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowArrayLoadOutOfBoundsInt
{
    private int array[];
    public ThrowArrayLoadOutOfBoundsInt()
    {
        this.array = new int[2];
    }

    @Obfuscation
    public int exec()
    {
        return this.array[2];
    }
}
