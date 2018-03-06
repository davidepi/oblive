package testclasses.fields;

import it.se.obfuscator.Obfuscate;

public class SetStaticFloat
{
    private static float fieldF;

    public SetStaticFloat()
    {
        SetStaticFloat.fieldF = 3.5f;
        this.setStatic(-0.5f);
    }

    public float getStatic()
    {
        return SetStaticFloat.fieldF;
    }

    @Obfuscate
    public void setStatic(float value)
    {
        SetStaticFloat.fieldF = value;
    }
}
