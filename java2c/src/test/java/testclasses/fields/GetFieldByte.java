package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;

public class GetFieldByte
{
    private byte fieldB;

    public GetFieldByte()
    {
        this.fieldB = 100;
    }

    @Obfuscation
    public byte getField()
    {
        return this.fieldB;
    }
}
