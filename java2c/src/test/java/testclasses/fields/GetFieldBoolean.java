package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;

public class GetFieldBoolean
{
    private boolean fieldZ;

    public GetFieldBoolean()
    {
        this.fieldZ = true;
    }

    @Obfuscation
    public boolean getField()
    {
        return this.fieldZ;
    }
}
