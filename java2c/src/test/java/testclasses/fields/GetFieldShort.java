package testclasses.fields;

import it.se.obfuscator.Obfuscate;

public class GetFieldShort
{
    private int fieldS;

    public GetFieldShort()
    {
        this.fieldS = 3000;
    }

    @Obfuscate
    public int getField()
    {
        return this.fieldS;
    }
}
