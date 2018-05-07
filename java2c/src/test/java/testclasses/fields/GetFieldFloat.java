package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;

public class GetFieldFloat
{
    private float fieldF;

    public GetFieldFloat()
    {
        this.fieldF = 3.5f;
    }

    @Obfuscation
    public float getField()
    {
        return this.fieldF;
    }
}
