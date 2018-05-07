package testclasses.exceptions.outofbounds.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowArrayLoadOutOfBoundsFloat
{
    private float array[];
    public ThrowArrayLoadOutOfBoundsFloat()
    {
        this.array = new float[2];
    }

    @Obfuscation
    public float exec()
    {
        return this.array[2];
    }
}
