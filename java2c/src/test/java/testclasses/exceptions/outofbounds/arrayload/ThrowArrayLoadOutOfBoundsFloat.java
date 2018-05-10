package testclasses.exceptions.outofbounds.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowArrayLoadOutOfBoundsFloat
{
    private float array[];

    public ThrowArrayLoadOutOfBoundsFloat()
    {
        this.array = new float[2];
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public float exec()
    {
        return this.array[2];
    }
}
