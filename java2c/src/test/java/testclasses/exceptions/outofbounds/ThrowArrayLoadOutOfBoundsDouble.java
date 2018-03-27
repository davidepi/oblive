package testclasses.exceptions.outofbounds;

import it.se.obfuscator.Obfuscate;

public class ThrowArrayLoadOutOfBoundsDouble
{
    private double array[];
    public ThrowArrayLoadOutOfBoundsDouble()
    {
        this.array = new double[2];
    }

    @Obfuscate
    public double exec()
    {
        return this.array[2];
    }
}
