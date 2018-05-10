package testclasses.exceptions.outofbounds.arraystore;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowArrayStoreOutOfBoundsFloat
{
    private float array[];

    public ThrowArrayStoreOutOfBoundsFloat()
    {
        this.array = new float[2];
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public float exec()
    {
        this.array[2] = 1;
        return this.array[2];
    }
}
