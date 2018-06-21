package testclasses.exceptions.outofbounds.arraystore;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowArrayStoreOutOfBoundsBoolean
{
    private boolean array[];

    public ThrowArrayStoreOutOfBoundsBoolean()
    {
        this.array = new boolean[2];
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public boolean exec()
    {
        this.array[2] = true;
        return this.array[2];
    }
}
