package testclasses.exceptions.outofbounds.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowArrayLoadOutOfBoundsLong
{
    private long array[];

    public ThrowArrayLoadOutOfBoundsLong()
    {
        this.array = new long[2];
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public long exec()
    {
        return this.array[2];
    }
}
