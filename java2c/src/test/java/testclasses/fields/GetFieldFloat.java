package testclasses.fields;

import it.se.obfuscator.Obfuscate;

public class GetFieldFloat
{
    private float fieldF;

    public GetFieldFloat()
    {
        this.fieldF = 3.5f;
    }

    @Obfuscate
    public float getField()
    {
        return this.fieldF;
    }
}
