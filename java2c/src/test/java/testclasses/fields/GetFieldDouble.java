package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;

public class GetFieldDouble
{
    private double fieldD;

    public GetFieldDouble()
    {
        this.fieldD = 3.14159265359;
    }

    @Obfuscation
    public double getField()
    {
        return this.fieldD;
    }
}
