package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;

public class SetFieldFloat
{
    private float fieldF;

    public SetFieldFloat()
    {
        this.fieldF = 3.5f;
        this.setField(-0.5f);
    }

    public float getField()
    {
        return this.fieldF;
    }

    @Obfuscation
    public void setField(float value){this.fieldF = value;}
}
