package testclasses.fields;

import it.se.obfuscator.Obfuscate;

public class GetFieldBoolean
{
    private boolean fieldZ;

    public GetFieldBoolean()
    {
        this.fieldZ = true;
    }

    @Obfuscate
    public boolean getField()
    {
        return this.fieldZ;
    }
}
