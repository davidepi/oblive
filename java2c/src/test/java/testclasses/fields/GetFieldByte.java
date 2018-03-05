package testclasses.fields;

import it.se.obfuscator.Obfuscate;

public class GetFieldByte
{
    private byte fieldB;

    public GetFieldByte()
    {
        this.fieldB = 100;
    }

    @Obfuscate
    public byte getField()
    {
        return this.fieldB;
    }
}
