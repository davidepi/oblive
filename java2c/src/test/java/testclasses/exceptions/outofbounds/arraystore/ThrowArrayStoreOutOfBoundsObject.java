package testclasses.exceptions.outofbounds.arraystore;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowArrayStoreOutOfBoundsObject
{
    private String array[];
    public ThrowArrayStoreOutOfBoundsObject()
    {
        this.array = new String[2];
    }

    @Obfuscation
    public String exec()
    {
        this.array[2] = "string0";
        return this.array[2];
    }
}
