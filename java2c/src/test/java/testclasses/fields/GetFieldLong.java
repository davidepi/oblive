package testclasses.fields;

import it.se.obfuscator.Obfuscate;

public class GetFieldLong
{
    private long fieldJ;

    public GetFieldLong()
    {
        this.fieldJ = 10000000000L;
    }

    @Obfuscate
    public long getField()
    {
        return this.fieldJ;
    }
}
