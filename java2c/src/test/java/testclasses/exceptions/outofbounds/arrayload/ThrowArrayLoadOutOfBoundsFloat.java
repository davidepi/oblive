package testclasses.exceptions.outofbounds.arrayload;

import it.se.obfuscator.Obfuscate;

public class ThrowArrayLoadOutOfBoundsFloat
{
    private float array[];
    public ThrowArrayLoadOutOfBoundsFloat()
    {
        this.array = new float[2];
    }

    @Obfuscate
    public float exec()
    {
        return this.array[2];
    }
}
