package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;

public class GetStaticDouble
{
    private static double fieldD;

    public GetStaticDouble()
    {
        GetStaticDouble.fieldD = 3.14159265359;
    }

    @Obfuscation
    public double getStatic()
    {
        return GetStaticDouble.fieldD;
    }
}
