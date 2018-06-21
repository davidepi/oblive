package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class GetStaticDouble
{
    private static double fieldD;

    public GetStaticDouble()
    {
        GetStaticDouble.fieldD = 3.14159265359;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public double getStatic()
    {
        return GetStaticDouble.fieldD;
    }
}
