package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;

public class SetStaticDouble
{
    private static double fieldD;

    public SetStaticDouble()
    {
        SetStaticDouble.fieldD = 3.14159265359;
        this.setStatic(2.7182818284590452353602874713527);
    }

    public double getStatic()
    {
        return SetStaticDouble.fieldD;
    }

    @Obfuscation
    public void setStatic(double value)
    {
        SetStaticDouble.fieldD = value;
    }
}
