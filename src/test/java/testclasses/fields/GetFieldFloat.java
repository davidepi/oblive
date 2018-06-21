package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class GetFieldFloat
{
    private float fieldF;

    public GetFieldFloat()
    {
        this.fieldF = 3.5f;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public float getField()
    {
        return this.fieldF;
    }
}
