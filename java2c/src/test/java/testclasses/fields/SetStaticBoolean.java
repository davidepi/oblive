package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;

public class SetStaticBoolean
{
    private static boolean fieldZ;

    public SetStaticBoolean()
    {
        SetStaticBoolean.fieldZ = false;
        this.setStatic(true);
    }

    public boolean getStatic()
    {
        return SetStaticBoolean.fieldZ;
    }

    @Obfuscation
    public void setStatic(boolean value)
    {
        SetStaticBoolean.fieldZ = value;
    }
}
