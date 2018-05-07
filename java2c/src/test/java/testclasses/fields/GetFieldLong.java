package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;

public class GetFieldLong
{
    private long fieldJ;

    public GetFieldLong()
    {
        this.fieldJ = 10000000000L;
    }

    @Obfuscation
    public long getField()
    {
        return this.fieldJ;
    }
}
