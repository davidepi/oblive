package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class GetFieldBoolean
{
    private boolean fieldZ;

    public GetFieldBoolean()
    {
        this.fieldZ = true;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public boolean getField()
    {
        return this.fieldZ;
    }
}
