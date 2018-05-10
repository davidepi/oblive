package testclasses.exceptions.outofbounds.arraystore;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowArrayStoreOutOfBoundsObject
{
    private String array[];

    public ThrowArrayStoreOutOfBoundsObject()
    {
        this.array = new String[2];
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public String exec()
    {
        this.array[2] = "string0";
        return this.array[2];
    }
}
