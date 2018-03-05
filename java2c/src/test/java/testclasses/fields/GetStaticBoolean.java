package testclasses.fields;

import it.se.obfuscator.Obfuscate;

public class GetStaticBoolean
{
    private static boolean fieldZ;

    public GetStaticBoolean()
    {
        GetStaticBoolean.fieldZ = true;
    }

    @Obfuscate
    public boolean getStatic()
    {
        return GetStaticBoolean.fieldZ;
    }
}
