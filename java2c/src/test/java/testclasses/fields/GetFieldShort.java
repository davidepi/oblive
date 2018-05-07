package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;

public class GetFieldShort
{
    private short fieldS;

    public GetFieldShort()
    {
        this.fieldS = 3000;
    }

    @Obfuscation
    public short getField()
    {
        return this.fieldS;
    }
}
