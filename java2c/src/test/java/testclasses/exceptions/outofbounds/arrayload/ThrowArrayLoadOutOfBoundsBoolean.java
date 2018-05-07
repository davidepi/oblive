package testclasses.exceptions.outofbounds.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowArrayLoadOutOfBoundsBoolean
{
    private boolean array[];
    public ThrowArrayLoadOutOfBoundsBoolean()
    {
        this.array = new boolean[2];
    }

    @Obfuscation
    public boolean exec()
    {
        return this.array[2];
    }
}
