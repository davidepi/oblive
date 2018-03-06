package testclasses.fields;

import it.se.obfuscator.Obfuscate;

public class GetStaticDouble
{
    private static double fieldD;

    public GetStaticDouble()
    {
        GetStaticDouble.fieldD = 3.14159265359;
    }

    @Obfuscate
    public double getStatic()
    {
        return GetStaticDouble.fieldD;
    }
}
