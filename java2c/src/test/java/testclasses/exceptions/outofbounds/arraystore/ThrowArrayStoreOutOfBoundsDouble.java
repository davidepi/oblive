package testclasses.exceptions.outofbounds.arraystore;

import it.se.obfuscator.Obfuscate;

public class ThrowArrayStoreOutOfBoundsDouble
{
    private double array[];
    public ThrowArrayStoreOutOfBoundsDouble()
    {
        this.array = new double[2];
    }

    @Obfuscate
    public double exec()
    {
        this.array[2] = 1;
        return this.array[2];
    }
}
