package testclasses.exceptions.outofbounds;

import it.se.obfuscator.Obfuscate;

public class ThrowArrayLoadOutOfBoundsBoolean
{
    private boolean array[];
    public ThrowArrayLoadOutOfBoundsBoolean()
    {
        this.array = new boolean[2];
    }

    @Obfuscate
    public boolean exec()
    {
        return this.array[2];
    }
}
