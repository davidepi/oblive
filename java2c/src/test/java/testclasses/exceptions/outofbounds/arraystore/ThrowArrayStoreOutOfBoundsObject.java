package testclasses.exceptions.outofbounds.arraystore;

import it.se.obfuscator.Obfuscate;

public class ThrowArrayStoreOutOfBoundsObject
{
    private String array[];
    public ThrowArrayStoreOutOfBoundsObject()
    {
        this.array = new String[2];
    }

    @Obfuscate
    public String exec()
    {
        this.array[2] = "string0";
        return this.array[2];
    }
}
