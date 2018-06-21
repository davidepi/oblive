package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class GetFieldByte
{
    private byte fieldB;

    public GetFieldByte()
    {
        this.fieldB = 100;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public byte getField()
    {
        return this.fieldB;
    }
}
