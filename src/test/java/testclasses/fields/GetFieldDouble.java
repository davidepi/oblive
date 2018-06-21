package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class GetFieldDouble
{
    private double fieldD;

    public GetFieldDouble()
    {
        this.fieldD = 3.14159265359;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public double getField()
    {
        return this.fieldD;
    }
}
