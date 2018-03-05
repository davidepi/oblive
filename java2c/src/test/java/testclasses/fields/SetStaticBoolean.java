package testclasses.fields;

import it.se.obfuscator.Obfuscate;

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

    @Obfuscate
    public void setStatic(boolean value)
    {
        SetStaticBoolean.fieldZ = value;
    }
}
