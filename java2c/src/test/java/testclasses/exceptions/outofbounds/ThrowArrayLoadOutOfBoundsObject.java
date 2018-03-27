package testclasses.exceptions.outofbounds;

import it.se.obfuscator.Obfuscate;

public class ThrowArrayLoadOutOfBoundsObject
{
    private String array[];
    public ThrowArrayLoadOutOfBoundsObject()
    {
        this.array = new String[2];
    }

    @Obfuscate
    public String exec()
    {
        return this.array[2];
    }
}
