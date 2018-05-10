package testclasses.exceptions.outofbounds.arraystore;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowArrayStoreOutOfBoundsByte
{
    private byte array[];

    public ThrowArrayStoreOutOfBoundsByte()
    {
        this.array = new byte[2];
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public byte exec()
    {
        this.array[2] = 1;
        return this.array[2];
    }
}
