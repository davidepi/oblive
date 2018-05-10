package testclasses.exceptions.outofbounds.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowArrayLoadOutOfBoundsInt
{
    private int array[];

    public ThrowArrayLoadOutOfBoundsInt()
    {
        this.array = new int[2];
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec()
    {
        return this.array[2];
    }
}
