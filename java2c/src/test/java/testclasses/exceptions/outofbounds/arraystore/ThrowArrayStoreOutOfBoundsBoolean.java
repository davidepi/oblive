package testclasses.exceptions.outofbounds.arraystore;

import it.se.obfuscator.Obfuscate;

public class ThrowArrayStoreOutOfBoundsBoolean
{
    private boolean array[];
    public ThrowArrayStoreOutOfBoundsBoolean()
    {
        this.array = new boolean[2];
    }

    @Obfuscate
    public boolean exec()
    {
        this.array[2] = true;
        return this.array[2];
    }
}
