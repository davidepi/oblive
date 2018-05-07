package testclasses.exceptions.outofbounds.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowArrayLoadOutOfBoundsObject
{
    private String array[];
    public ThrowArrayLoadOutOfBoundsObject()
    {
        this.array = new String[2];
    }

    @Obfuscation
    public String exec()
    {
        return this.array[2];
    }
}
