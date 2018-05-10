package testclasses.exceptions.outofbounds.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowArrayLoadOutOfBoundsBoolean
{
    private boolean array[];

    public ThrowArrayLoadOutOfBoundsBoolean()
    {
        this.array = new boolean[2];
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public boolean exec()
    {
        return this.array[2];
    }
}
