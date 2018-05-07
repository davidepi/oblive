package testclasses.exceptions.outofbounds.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowArrayLoadOutOfBoundsDouble
{
    private double array[];
    public ThrowArrayLoadOutOfBoundsDouble()
    {
        this.array = new double[2];
    }

    @Obfuscation
    public double exec()
    {
        return this.array[2];
    }
}
