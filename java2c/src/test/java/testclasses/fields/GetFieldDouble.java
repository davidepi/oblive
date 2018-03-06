package testclasses.fields;

import it.se.obfuscator.Obfuscate;

public class GetFieldDouble
{
    private double fieldD;

    public GetFieldDouble()
    {
        this.fieldD = 3.14159265359;
    }

    @Obfuscate
    public double getField()
    {
        return this.fieldD;
    }
}
