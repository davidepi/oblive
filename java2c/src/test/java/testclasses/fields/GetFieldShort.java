package testclasses.fields;

import it.se.obfuscator.Obfuscate;

public class GetFieldShort
{
    private short fieldS;

    public GetFieldShort()
    {
        this.fieldS = 3000;
    }

    @Obfuscate
    public short getField()
    {
        return this.fieldS;
    }
}
